package com.example.appbanquanao.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ImageSPAdapterViewPage extends PagerAdapter {
    List<Integer> lstAnhSP;

    public ImageSPAdapterViewPage(List<Integer> lstAnhSP) {
        this.lstAnhSP = lstAnhSP;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView sanphamImageView = new ImageView(container.getContext());
        sanphamImageView.setImageResource(lstAnhSP.get(position));
        container.addView(sanphamImageView,0);
        return sanphamImageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return lstAnhSP.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
