package com.example.appbanquanao.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appbanquanao.Fragment.ChiTietSanPhamFragment;
import com.example.appbanquanao.Fragment.ThongTinSanPhamFragment;
import com.example.appbanquanao.Fragment.ThongTinThemSPFragment;

public class ThongTinSanPhamAdapter extends FragmentPagerAdapter {
    private int totalTab;

    public ThongTinSanPhamAdapter(@NonNull FragmentManager fm, int totalTab) {
        super(fm, totalTab);
        this.totalTab=totalTab;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                ThongTinSanPhamFragment thongTinSanPhamFragment=new ThongTinSanPhamFragment();
                return thongTinSanPhamFragment;
            case 1:
                ChiTietSanPhamFragment chiTietSanPhamFragment=new ChiTietSanPhamFragment();
                return chiTietSanPhamFragment;
            case 2:
                ThongTinThemSPFragment thongTinThemSPFragment =new ThongTinThemSPFragment();
                return thongTinThemSPFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return totalTab;
    }
}
