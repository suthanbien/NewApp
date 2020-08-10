package com.example.appbanquanao.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.TrangChuAdapter;
import com.example.appbanquanao.Model.HangHoaModel;
import com.example.appbanquanao.Model.SliderModel;
import com.example.appbanquanao.Model.TrangChuModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

public class LoaiSanPhamActivity extends AppCompatActivity {
    private RecyclerView RecyclerViewLoaiSP;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_san_pham);
        //set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("TenLSP");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerViewLoaiSP = findViewById(R.id.RecyclerView_LoaiSP);

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

        //phần list SP

        LinearLayoutManager testLinearLayoutManager =new LinearLayoutManager(this);
        testLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerViewLoaiSP.setLayoutManager(testLinearLayoutManager);

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
        RecyclerViewLoaiSP.setAdapter(trangChuAdapter);
        trangChuAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icoin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id== R.id.mnuTimKiem){
            Toast.makeText(this,"mnuTimKiem",Toast.LENGTH_SHORT).show();
            return true;
        }if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}