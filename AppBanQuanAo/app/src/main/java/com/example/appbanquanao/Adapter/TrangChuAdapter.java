package com.example.appbanquanao.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appbanquanao.Activity.ViewAllActivity;
import com.example.appbanquanao.Model.HangHoaModel;
import com.example.appbanquanao.Model.SliderModel;
import com.example.appbanquanao.Model.TrangChuModel;
import com.example.appbanquanao.R;

import java.util.List;

public class TrangChuAdapter extends RecyclerView.Adapter {
    private List<TrangChuModel> lstTrangChuModel;

    public TrangChuAdapter(List<TrangChuModel> lstTrangChuModel) {
        this.lstTrangChuModel = lstTrangChuModel;
    }

    @Override
    public int getItemViewType(int position) {
       switch(lstTrangChuModel.get(position).getType()){
           case 0:
               return TrangChuModel.BANNER_SLIDER;

           case 1:
               return TrangChuModel.STRIP_AD_BANNER;
           case 2:
               return TrangChuModel.HORIZONTAL_PRODUC_VIEW;
           case 3:
               return TrangChuModel.GRID_PRODUC_VIEW;

               default:
                   return -1;
       }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType) {
            case TrangChuModel.BANNER_SLIDER:

                View bannerSliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_ad_layout,parent,false);
                return new BannerSliderViewHolder(bannerSliderView);

            case TrangChuModel.STRIP_AD_BANNER:

                View stripAdBannerView= LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_ad_layout,parent,false);
                return new StripAdBannerViewHolder(stripAdBannerView);
            case TrangChuModel.HORIZONTAL_PRODUC_VIEW:
                View horizontalProducView= LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_hot_layout,parent,false);
                return new HorizontalProducViewHolder(horizontalProducView);
            case TrangChuModel.GRID_PRODUC_VIEW:
                View gridProducView= LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_layout,parent,false);
                return new GridProducViewHolder(gridProducView);


                default: return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch(lstTrangChuModel.get(position).getType()){
            case TrangChuModel.BANNER_SLIDER:
               List<SliderModel> lstSliderModel =lstTrangChuModel.get(position).getLstSliderModdel();
                ((BannerSliderViewHolder) holder ).SetBannerSliderViewPage(lstSliderModel);
                break;
            case TrangChuModel.STRIP_AD_BANNER:
                int resource =lstTrangChuModel.get(position).getResource();
                String color =lstTrangChuModel.get(position).getBackgroundColor();
                ((StripAdBannerViewHolder) holder ).SetStripAdBanner(resource,color);
                break;
            case TrangChuModel.HORIZONTAL_PRODUC_VIEW:
                String title =lstTrangChuModel.get(position).getTitle();
                List<HangHoaModel> lstHangHoaModel = lstTrangChuModel.get(position).getLstHangHoaModel();
                ((HorizontalProducViewHolder) holder ).SetHorizontalProducLayout(lstHangHoaModel,title);
                break;

            case TrangChuModel.GRID_PRODUC_VIEW:
                String titleTrending =lstTrangChuModel.get(position).getTitle();
                List<HangHoaModel> lstHangHoaTrendingModel = lstTrangChuModel.get(position).getLstHangHoaModel();
                ((GridProducViewHolder) holder ).SetGridProductLayout(lstHangHoaTrendingModel,titleTrending);
                break;

            default:
                return ;
        }
    }

    @Override
    public int getItemCount() {
        return lstTrangChuModel.size();
    }

    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {
        private ViewPager2 bannerSliderViewPage;
        private Handler slideHandler=new Handler();

        //phần banner
        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);

            bannerSliderViewPage = itemView.findViewById(R.id.image_sanpham_ViewPage);



        }

        private void SetBannerSliderViewPage (List<SliderModel>lstSliderModel){
            bannerSliderViewPage.setAdapter(new SliderAdapter(lstSliderModel,bannerSliderViewPage));

            bannerSliderViewPage.setClipToPadding(false);
            bannerSliderViewPage.setClipChildren(false);

            bannerSliderViewPage.setOffscreenPageLimit(3);
            bannerSliderViewPage.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_ALWAYS);


            CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r=1-Math.abs(position);
                    page.setScaleY(0.85f+r*0.15f);
                }
            });
            bannerSliderViewPage.setPageTransformer(compositePageTransformer);
            bannerSliderViewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);

                    slideHandler.removeCallbacks(sliderRunnable);
                    slideHandler.postDelayed(sliderRunnable,3000);
                }
            });
        }
        private Runnable sliderRunnable=new Runnable() {
            @Override
            public void run() {
                bannerSliderViewPage.setCurrentItem(bannerSliderViewPage.getCurrentItem()+1);
            }
        };


    }


    public class StripAdBannerViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout stripAdContainer;
        private ImageView imageViewStripAd;
        public StripAdBannerViewHolder(@NonNull View itemView) {
            super(itemView);

            stripAdContainer = itemView.findViewById(R.id.strip_ad_container);
            imageViewStripAd = itemView.findViewById(R.id.imageView_strip_ad);
        }
        public void SetStripAdBanner(int resource,String color){
            imageViewStripAd.setImageResource(resource);
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class HorizontalProducViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView recyclerViewScrollLayout;
        private Button buttonXemThem;
        private TextView textViewDealsHot;
        public HorizontalProducViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerViewScrollLayout = itemView.findViewById(R.id.recyclerView_scroll_layout);
            buttonXemThem = itemView.findViewById(R.id.button_XemThem_dealHot);
            textViewDealsHot = itemView.findViewById(R.id.textView_deals_hot);
        }

        public void SetHorizontalProducLayout(List<HangHoaModel> lstDealsHotModel, String title){
            textViewDealsHot.setText(title);

            if(lstDealsHotModel.size()>8){
                buttonXemThem.setVisibility(View.VISIBLE);
                buttonXemThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent viewAllIntent = new Intent(itemView.getContext(), ViewAllActivity.class);
                        viewAllIntent.putExtra("layout_code",0);
                        itemView.getContext().startActivity(viewAllIntent);
                    }
                });
            }else{
                buttonXemThem.setVisibility(View.INVISIBLE);
            }



            DealsHotAdapter dealsHotAdapter=new DealsHotAdapter(lstDealsHotModel);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

            recyclerViewScrollLayout.setLayoutManager(linearLayoutManager);
            recyclerViewScrollLayout.setAdapter(dealsHotAdapter);
            dealsHotAdapter.notifyDataSetChanged();
        }
    }

    public class GridProducViewHolder extends RecyclerView.ViewHolder{
        private Button buttonXemThemTrending;
        private TextView textViewTrendingLayout;
        private GridView gridTraoLuu;
        public GridProducViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonXemThemTrending = itemView.findViewById(R.id.button_XemThem_trending);
            textViewTrendingLayout = itemView.findViewById(R.id.textView_trending_layout);
            gridTraoLuu = itemView.findViewById(R.id.grid_Trao_Luu);
        }

        public void SetGridProductLayout(List<HangHoaModel> lstDealsHotModel, String title){
            textViewTrendingLayout.setText(title);

            gridTraoLuu.setAdapter(new TrendingAdapter(lstDealsHotModel));
            buttonXemThemTrending.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent viewAllIntent = new Intent(itemView.getContext(), ViewAllActivity.class);
                    viewAllIntent.putExtra("layout_code",1);
                    itemView.getContext().startActivity(viewAllIntent);
                }
            });
        }
    }
}
