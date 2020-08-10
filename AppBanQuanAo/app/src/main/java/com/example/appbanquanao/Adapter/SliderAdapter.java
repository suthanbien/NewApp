package com.example.appbanquanao.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appbanquanao.Model.SliderModel;
import com.example.appbanquanao.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;


public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{
    private List<SliderModel> lstSliderModel;
    private ViewPager2 viewpager2;

    public SliderAdapter(List<SliderModel> lstSliderModel, ViewPager2 viewpager2) {
        this.lstSliderModel = lstSliderModel;
        this.viewpager2 = viewpager2;

    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
      //  Log.e("ERROR","lỗi thực thi câu lệnh SELECT: "+ lstSliderModel.size());
        holder.setImage(lstSliderModel.get(position));
        if(position==lstSliderModel.size()-2){
            viewpager2.post(runnable);
    }
    }

    @Override
    public int getItemCount() {
        return lstSliderModel.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;
     public SliderViewHolder(@NonNull View itemView) {
         super(itemView);
         imageView=itemView.findViewById(R.id.image_item_view);
     }
     void setImage(SliderModel sliderModel){
         imageView.setImageResource(sliderModel.getBanner());
     }
    }
    private Runnable runnable =new Runnable() {
        @Override
        public void run() {
            lstSliderModel.addAll(lstSliderModel);
            notifyDataSetChanged();
        }
    };
}
