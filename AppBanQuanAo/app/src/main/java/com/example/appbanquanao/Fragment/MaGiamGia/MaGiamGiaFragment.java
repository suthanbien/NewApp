package com.example.appbanquanao.Fragment.MaGiamGia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.MaGiamGiaAdapter;
import com.example.appbanquanao.Model.MaGiamGiaModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

public class MaGiamGiaFragment extends Fragment {
    private RecyclerView maGiamGiaRecyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ma_giam_gia, container, false);

        maGiamGiaRecyclerView = view.findViewById(R.id.recyclerView_MaGiamGia);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        maGiamGiaRecyclerView.setLayoutManager(layoutManager);

        List<MaGiamGiaModel> lstMaGiamGiaModel=new ArrayList<>();
        lstMaGiamGiaModel.add(new MaGiamGiaModel("Mã Giảm Giá 1","Đến ngày 1/8/2021","Giảm 20% khi mua các sản phẩm. Tối đa 300.000VNĐ"));
        lstMaGiamGiaModel.add(new MaGiamGiaModel("Mã Giảm Giá 2","Đến ngày 1/9/2021","Giảm 30% khi mua các sản phẩm. Tối đa 200.000VNĐ"));
        lstMaGiamGiaModel.add(new MaGiamGiaModel("Mã Giảm Giá 3","Đến ngày 1/10/2021","Giảm 40% khi mua các sản phẩm. Tối đa 100.000VNĐ"));
        lstMaGiamGiaModel.add(new MaGiamGiaModel("Mã Giảm Giá 4","Đến ngày 1/11/2021","Giảm 50% khi mua các sản phẩm. Tối đa 50.000VNĐ"));
        lstMaGiamGiaModel.add(new MaGiamGiaModel("Mã Giảm Giá 5","Đến ngày 1/5/2021","Giảm 20% khi mua các sản phẩm. Tối đa 500.000VNĐ"));
        lstMaGiamGiaModel.add(new MaGiamGiaModel("Mã Giảm Giá 6","Đến ngày 1/4/2021","Giảm 50% khi mua các sản phẩm. Tối đa 400.000VNĐ"));
        lstMaGiamGiaModel.add(new MaGiamGiaModel("Mã Giảm Giá 7","Đến ngày 1/6/2021","Giảm 40% khi mua các sản phẩm. Tối đa 700.000VNĐ"));

        MaGiamGiaAdapter maGiamGiaAdapter=new MaGiamGiaAdapter(lstMaGiamGiaModel);

        maGiamGiaRecyclerView.setAdapter(maGiamGiaAdapter);
        maGiamGiaAdapter .notifyDataSetChanged();


        return view;
    }
}