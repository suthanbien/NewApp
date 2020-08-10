package com.example.appbanquanao.Fragment.DonHang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.OrderAdapter;
import com.example.appbanquanao.Model.OrderModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

public class DonHangFragment extends Fragment {

    private RecyclerView donHangRecyclerView;




    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_don_hang, container, false);
        donHangRecyclerView = view.findViewById(R.id.don_Hang__RecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        donHangRecyclerView.setLayoutManager(layoutManager);

        List<OrderModel> lstOrderModels = new ArrayList<>();
        lstOrderModels.add(new OrderModel(R.mipmap.quanao1,"Quần Què 1","Đã giao và thanh toán",0,0));
        lstOrderModels.add(new OrderModel(R.mipmap.quanao2,"Quần Què 2","Đang giao",1,1));
        lstOrderModels.add(new OrderModel(R.mipmap.quanao3,"Quần Què 3","Đã hủy",2,3));lstOrderModels.add(new OrderModel(R.mipmap.quanao1,"Quần Què 1","Đã giao và thanh toán",0,0));
        lstOrderModels.add(new OrderModel(R.mipmap.quanao2,"Quần Què 2","Đang giao",1,1));
        lstOrderModels.add(new OrderModel(R.mipmap.quanao3,"Quần Què 3","Đã hủy",2,3));

        OrderAdapter orderAdapter=new OrderAdapter(lstOrderModels);
        donHangRecyclerView.setAdapter(orderAdapter);
        orderAdapter.notifyDataSetChanged();

        return view;
    }
}