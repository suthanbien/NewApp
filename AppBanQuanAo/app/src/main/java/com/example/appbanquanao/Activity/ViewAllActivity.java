package com.example.appbanquanao.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.TrendingAdapter;
import com.example.appbanquanao.Adapter.YeuThichAdapter;
import com.example.appbanquanao.Model.HangHoaModel;
import com.example.appbanquanao.Model.YeuThichModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    private RecyclerView viewAllRecycleView;
    private GridView viewAllGidView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);



        Toolbar toolbar = findViewById(R.id.toolbar_ViewAll);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        viewAllRecycleView = findViewById(R.id.viewAllRecycleView);
        viewAllGidView = findViewById(R.id.viewAllGidView);

        int layout_code=getIntent().getIntExtra("layout_code",-1);
        if(layout_code==0){
            getSupportActionBar().setTitle("Deals of the day");

            viewAllRecycleView.setVisibility(View.VISIBLE);
            viewAllGidView.setVisibility(View.GONE);
            LinearLayoutManager testLinearLayoutManager =new LinearLayoutManager(this);
            testLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            viewAllRecycleView.setLayoutManager(testLinearLayoutManager);

            List<YeuThichModel> lstYeuthichModel=new ArrayList<>();
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao1, "Áo Què 1",  1,  "3.5",  120,  "200.000VNĐ",  "150.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao2, "Áo Què 2",  2,  "4.5",  121,  "300.000VNĐ",  "250.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao3, "Áo Què 3",  3,  "5",  122,  "400.000VNĐ",  "350.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao2, "Quần Què 2",  4,  "3.5",  123,  "500.000VNĐ",  "450.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao1, "Quần Què 3",  5,  "3",  124,  "600.000VNĐ",  "550.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao3, "Quần Què 1",  6,  "2",  125,  "700.000VNĐ",  "650.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao2, "Áo Què 2",  2,  "4.5",  121,  "300.000VNĐ",  "250.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao3, "Áo Què 3",  3,  "5",  122,  "400.000VNĐ",  "350.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao2, "Quần Què 2",  4,  "3.5",  123,  "500.000VNĐ",  "450.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao1, "Quần Què 3",  5,  "3",  124,  "600.000VNĐ",  "550.000VNĐ"));
            lstYeuthichModel.add(new YeuThichModel(R.mipmap.quanao3, "Quần Què 1",  6,  "2",  125,  "700.000VNĐ",  "650.000VNĐ"));

            YeuThichAdapter yeuThichAdapter=new YeuThichAdapter(lstYeuthichModel,false);
            viewAllRecycleView.setAdapter(yeuThichAdapter);
            yeuThichAdapter.notifyDataSetChanged();
        }else {
            getSupportActionBar().setTitle("Trending !!");
            viewAllRecycleView.setVisibility(View.GONE);
            viewAllGidView.setVisibility(View.VISIBLE);
            List<HangHoaModel> lstDealsHotModel = new ArrayList<HangHoaModel>();
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1, "Quần của Tí", "Quần có 1 không 2", "Chỉ từ: 200.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2, "Quần của Tèo", "26% kháng mọi sát thương", "Chỉ từ: 300.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao3, "Quần của Tũn", "Tỉ lệ 200% té SML", "Chỉ từ: 500.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1, "Quần của Abe", "Quần có 1 không 2", "Chỉ từ: 100.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao3, "Set đồ hot", "95% Tỉ lệ ăn hành", "Chỉ từ: 500.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2, "Set Umbala", "1000% Kháng Phép", "Chỉ từ: 1.600.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2, "Quần của Huck", "Chất liệu bềnh nhất vũ trụ", "Chỉ từ: 500.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1, "Quần què", "Thiết kế độc lạ", "Chỉ từ: 800.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1, "Quần của Abe1", "Quần có 1 không 2", "Chỉ từ: 100.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao3, "Set đồ hot1", "95% Tỉ lệ ăn hành", "Chỉ từ: 500.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2, "Set Umbala1", "1000% Kháng Phép", "Chỉ từ: 1.600.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao2, "Quần của Huck1", "Chất liệu bềnh nhất vũ trụ", "Chỉ từ: 500.000 VNĐ"));
            lstDealsHotModel.add(new HangHoaModel(R.mipmap.quanao1, "Quần què1", "Thiết kế độc lạ", "Chỉ từ: 800.000 VNĐ"));

            TrendingAdapter trendingAdapter = new TrendingAdapter(lstDealsHotModel);
            viewAllGidView.setAdapter(trendingAdapter);
            // trendingAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}