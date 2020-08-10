package com.example.appbanquanao.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.ChiTietSPAdapter;
import com.example.appbanquanao.Model.ChiTietSanPhamModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChiTietSanPhamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChiTietSanPhamFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView chiTietSPRecyclerView;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChiTietSanPhamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChiTietSanPhamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChiTietSanPhamFragment newInstance(String param1, String param2) {
        ChiTietSanPhamFragment fragment = new ChiTietSanPhamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chi_tiet_san_pham, container, false);

        chiTietSPRecyclerView = view.findViewById(R.id.chiTietSP_RecyclerView);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        chiTietSPRecyclerView.setLayoutManager(linearLayoutManager);

        List<ChiTietSanPhamModel> lstChiTietSanPham = new ArrayList<>();

        lstChiTietSanPham.add(new ChiTietSanPhamModel(0,"Size"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size L","10 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size M","11 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size N","12 cái"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(0,"Màu"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Xanh","10 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Đỏ","11 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Vàng","12 cái"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(0,"Size"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size L","10 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size M","11 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size N","12 cái"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(0,"Màu"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Xanh","10 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Đỏ","11 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Vàng","12 cái"));

       lstChiTietSanPham.add(new ChiTietSanPhamModel(0,"Size"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size L","10 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size M","11 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Size N","12 cái"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(0,"Màu"));

        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Xanh","10 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Đỏ","11 cái"));
        lstChiTietSanPham.add(new ChiTietSanPhamModel(1,"Vàng","12 cái"));

        ChiTietSPAdapter chiTietSPAdapter=new ChiTietSPAdapter(lstChiTietSanPham);
        chiTietSPRecyclerView.setAdapter(chiTietSPAdapter);


        chiTietSPAdapter.notifyDataSetChanged();

        return view;
    }
}