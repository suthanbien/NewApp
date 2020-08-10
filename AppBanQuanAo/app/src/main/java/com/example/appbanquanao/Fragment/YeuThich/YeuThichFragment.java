package com.example.appbanquanao.Fragment.YeuThich;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.YeuThichAdapter;
import com.example.appbanquanao.Model.YeuThichModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

public class YeuThichFragment extends Fragment {
    public static YeuThichFragment newInstance() {
        return new YeuThichFragment();
    }


    private RecyclerView yeuthichRecyclerView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view=  inflater.inflate(R.layout.yeu_thich_fragment, container, false);
        yeuthichRecyclerView = view.findViewById(R.id.yeuthich_RecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        yeuthichRecyclerView.setLayoutManager(layoutManager);

        List<YeuThichModel> lstYeuthichModel=new ArrayList<>();
        lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao1, "Áo Què 1",  1,  "3.5",  120,  "200.000VNĐ",  "150.000VNĐ"));
        lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao2, "Áo Què 2",  2,  "4.5",  121,  "300.000VNĐ",  "250.000VNĐ"));
        lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao3, "Áo Què 3",  3,  "5",  122,  "400.000VNĐ",  "350.000VNĐ"));
        lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao2, "Quần Què 2",  4,  "3.5",  123,  "500.000VNĐ",  "450.000VNĐ"));
        lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao1, "Quần Què 3",  5,  "3",  124,  "600.000VNĐ",  "550.000VNĐ"));
        lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao3, "Quần Què 1",  6,  "2",  125,  "700.000VNĐ",  "650.000VNĐ"));

        YeuThichAdapter yeuThichAdapter=new YeuThichAdapter(lstYeuthichModel,true);
        yeuthichRecyclerView.setAdapter(yeuThichAdapter);
        yeuThichAdapter.notifyDataSetChanged();


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}