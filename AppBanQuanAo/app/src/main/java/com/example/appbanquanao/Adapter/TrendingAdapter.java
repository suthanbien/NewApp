package com.example.appbanquanao.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbanquanao.Activity.SanPhamActivity;
import com.example.appbanquanao.Model.HangHoaModel;
import com.example.appbanquanao.R;

import java.util.List;

public class TrendingAdapter extends BaseAdapter {
    List<HangHoaModel> lstHangHoaModels ;

    public TrendingAdapter(List<HangHoaModel> lstHangHoaModels) {
        this.lstHangHoaModels = lstHangHoaModels;
    }

    @Override
    public int getCount() {
        return lstHangHoaModels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if(convertView==null){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.hang_hoa_item_layout,  null);
            view.setElevation(0);
            //view.setBackgroundColor();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent trendingLayoutInten=new Intent(parent.getContext(), SanPhamActivity.class);
                    parent.getContext().startActivity(trendingLayoutInten);
                }
            });

            ImageView SanPhamImageView=view.findViewById(R.id.imageView_AnhSP_TT);
            TextView textViewTenDealsHot = view.findViewById(R.id.textView_Ten_DealsHot);
            TextView textViewMoTaDealsHot = view.findViewById(R.id.textView_MoTa_DealsHot);
            TextView textViewGiaDealsHot = view.findViewById(R.id.textView_Gia_DealsHot);
            SanPhamImageView.setImageResource(lstHangHoaModels.get(position).getHinhAnh());
            textViewTenDealsHot.setText(lstHangHoaModels.get(position).getTen());
            textViewMoTaDealsHot.setText(lstHangHoaModels.get(position).getMota());
            textViewGiaDealsHot.setText(lstHangHoaModels.get(position).getGia());


        }else{
            view =convertView;

        }
        return view;
    }
}
