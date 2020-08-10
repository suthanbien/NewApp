package com.example.appbanquanao.Fragment.TrangChu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.LoaiSanPhamAdapter;
import com.example.appbanquanao.Adapter.TrangChuAdapter;
import com.example.appbanquanao.Model.HangHoaModel;
import com.example.appbanquanao.Model.LoaiSanPhamModel;
import com.example.appbanquanao.Model.SliderModel;
import com.example.appbanquanao.Model.TrangChuModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;


public class TrangChuFragment extends Fragment {

    //loại SP
    private TrangChuModel homeViewModel;
    private RecyclerView loaiSP_RecyclerView;
    private LoaiSanPhamAdapter loaiSP_Adapter;
    private RecyclerView testRecyclerView;




    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        //phần loại SP
        loaiSP_RecyclerView=view.findViewById(R.id.recyclerView_LoaiSP);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        loaiSP_RecyclerView.setLayoutManager(layoutManager);

        List<LoaiSanPhamModel> lstLoaiSP=new ArrayList<LoaiSanPhamModel>();
        lstLoaiSP.add(new LoaiSanPhamModel("link","Áo Kiểu"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Áo Khoác"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Áo Sơ Mi"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Áo Thun"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Đầm Chữ A"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Đầm Maxi"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Đầm Ôm"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Loại Khác"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Quần Dài"));
        lstLoaiSP.add(new LoaiSanPhamModel("link","Quần Shorts"));


        loaiSP_Adapter=new LoaiSanPhamAdapter(lstLoaiSP);
        loaiSP_RecyclerView.setAdapter(loaiSP_Adapter);
        loaiSP_Adapter.notifyDataSetChanged();

        //phần panner


       List<SliderModel> lstSliderModel=new ArrayList<SliderModel>();
        lstSliderModel.add(new SliderModel(R.mipmap.banner1));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));
        lstSliderModel.add(new SliderModel(R.mipmap.banner5));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));
        lstSliderModel.add(new SliderModel(R.mipmap.banner1));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));
        lstSliderModel.add(new SliderModel(R.mipmap.banner5));
        lstSliderModel.add(new SliderModel(R.mipmap.banner2));
        lstSliderModel.add(new SliderModel(R.mipmap.banner3));
        lstSliderModel.add(new SliderModel(R.mipmap.banner4));


        //phần Deals Hot
        List<HangHoaModel> lstDealsHotModel=new ArrayList<HangHoaModel>();
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1,"Quần của Tí","Quần có 1 không 2","Chỉ từ: 200.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2,"Quần của Tèo","26% kháng mọi sát thương","Chỉ từ: 300.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao3,"Quần của Tũn","Tỉ lệ 200% té SML","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1,"Quần của Abe","Quần có 1 không 2","Chỉ từ: 100.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao3,"Set đồ hot","95% Tỉ lệ ăn hành","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2,"Set Umbala","1000% Kháng Phép","Chỉ từ: 1.600.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2,"Quần của Huck","Chất liệu bềnh nhất vũ trụ","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1,"Quần què","Thiết kế độc lạ","Chỉ từ: 800.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1,"Quần của Abe1","Quần có 1 không 2","Chỉ từ: 100.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao3,"Set đồ hot1","95% Tỉ lệ ăn hành","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2,"Set Umbala1","1000% Kháng Phép","Chỉ từ: 1.600.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2,"Quần của Huck1","Chất liệu bềnh nhất vũ trụ","Chỉ từ: 500.000 VNĐ"));
        lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1,"Quần què1","Thiết kế độc lạ","Chỉ từ: 800.000 VNĐ"));


        //phần list SP

         testRecyclerView = view.findViewById(R.id.trang_chu_RecyclerView);
        LinearLayoutManager testLinearLayoutManager =new LinearLayoutManager(getContext());
        testLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testRecyclerView.setLayoutManager(testLinearLayoutManager);

        List<TrangChuModel> lstTrangChuModels = new ArrayList<>();
        lstTrangChuModels.add(new TrangChuModel(0,lstSliderModel));
        lstTrangChuModels.add(new TrangChuModel(1, R.mipmap.adbanner1,"#3700B3"));
        lstTrangChuModels.add(new TrangChuModel(2,"Deals of the Day",lstDealsHotModel));
        lstTrangChuModels.add(new TrangChuModel(3,"Trending !!",lstDealsHotModel));
        lstTrangChuModels.add(new TrangChuModel(0,lstSliderModel));
        lstTrangChuModels.add(new TrangChuModel(1, R.mipmap.adbanner2,"#3700B3"));
        lstTrangChuModels.add(new TrangChuModel(2,"Deals of the Day",lstDealsHotModel));
        lstTrangChuModels.add(new TrangChuModel(3,"Trending !!",lstDealsHotModel));
        lstTrangChuModels.add(new TrangChuModel(0,lstSliderModel));
        lstTrangChuModels.add(new TrangChuModel(1, R.mipmap.adbaner3,"#3700B3"));
        lstTrangChuModels.add(new TrangChuModel(2,"Deals of the Day",lstDealsHotModel));
        lstTrangChuModels.add(new TrangChuModel(3,"Trending !!",lstDealsHotModel));

        TrangChuAdapter trangChuAdapter=new TrangChuAdapter(lstTrangChuModels);
        testRecyclerView.setAdapter(trangChuAdapter);
        trangChuAdapter.notifyDataSetChanged();


        return view;
    }


}