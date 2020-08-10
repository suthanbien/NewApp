package com.example.appbanquanao.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appbanquanao.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ImageSanPhamAdapter extends RecyclerView.Adapter<ImageSanPhamAdapter.ImageSanPhamViewHolder> {
    private List<Integer> lstAnhSP;
    private ViewPager2 viewpager2;

    public ImageSanPhamAdapter(List<Integer> lstAnhSP, ViewPager2 viewpager2) {
        this.lstAnhSP = lstAnhSP;
        this.viewpager2 = viewpager2;
    }

    @NonNull
    @Override
    public ImageSanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ImageSanPhamAdapter.ImageSanPhamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSanPhamViewHolder holder, int position) {
        holder.setImage(lstAnhSP.get(position));
        if(position==lstAnhSP.size()-2) {
            viewpager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return lstAnhSP.size();
    }

    class ImageSanPhamViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;
        public ImageSanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_item_view);
        }
        void setImage(int sliderModel){
            imageView.setImageResource(sliderModel);
        }
    }
    private Runnable runnable =new Runnable() {
        @Override
        public void run() {
            lstAnhSP.addAll(lstAnhSP);
            notifyDataSetChanged();
        }
    };
}
