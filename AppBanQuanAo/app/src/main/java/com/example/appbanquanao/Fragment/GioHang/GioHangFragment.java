package com.example.appbanquanao.Fragment.GioHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Activity.DelivertyActivity;
import com.example.appbanquanao.Adapter.GioHangAdapter;
import com.example.appbanquanao.Model.GioHangItemModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

public class GioHangFragment extends Fragment {

    private RecyclerView cartItemRecyclerView;
    private LinearLayout linearLayoutCartLayout;
    private Button cartContinuteBtn;




    public static GioHangFragment newInstance() {
        return new GioHangFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_gio_hang, container, false);

        cartItemRecyclerView = view.findViewById(R.id.cart_Item_RecyclerView);
        linearLayoutCartLayout = view.findViewById(R.id.linearLayout_CartLayout);
        cartContinuteBtn = view.findViewById(R.id.cart_continute_btn);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemRecyclerView.setLayoutManager(layoutManager);

        List<GioHangItemModel> lstGioHangItemModel=new ArrayList<>();
        lstGioHangItemModel.add(new GioHangItemModel(0, R.mipmap.quanao1,"Quần què 1",2,"200.000","500.000",1,0,3));
        lstGioHangItemModel.add(new GioHangItemModel(0, R.mipmap.quanao2,"Quần què 2",3,"400.000","700.000",2,1,4));
       lstGioHangItemModel.add(new GioHangItemModel(0, R.mipmap.quanao3,"Quần què 3",4,"600.000","900.000",3,2,5));
        lstGioHangItemModel.add(new GioHangItemModel(1,"Price 3 Item","1600000","free","2600000","2500000"));

        GioHangAdapter gioHangAdapter=new GioHangAdapter(lstGioHangItemModel);
        cartItemRecyclerView.setAdapter(gioHangAdapter);
        gioHangAdapter.notifyDataSetChanged();

        cartContinuteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delliverIntent = new Intent(getContext(), DelivertyActivity.class);
                getContext().startActivity(delliverIntent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}