package com.example.appbanquanao.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.appbanquanao.Adapter.ImageSPAdapterViewPage;
import com.example.appbanquanao.Adapter.ThongTinSanPhamAdapter;
import com.example.appbanquanao.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SanPhamActivity extends AppCompatActivity {
    private ViewPager imageSanphamViewPage;
    private TabLayout soluongAnhSp;
    private Handler slideHandler=new Handler();
    private FloatingActionButton btnThemVaoYeuThich;
    private Button buyNowBtn;


    private TabLayout thongTinSPTabLayout;
    private ViewPager thongTinSPViewPage;

    //phần đánh giá
    private LinearLayout danhgiaLayout;

    private boolean themVaoYeuThich=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        //set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("TenSP");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //ánh xạ
        imageSanphamViewPage = findViewById(R.id.image_sanpham_ViewPage);
        soluongAnhSp = findViewById(R.id.soluong_anhSp);
        btnThemVaoYeuThich = findViewById(R.id.btnThemVaoYeuThich);
        thongTinSPTabLayout = findViewById(R.id.thongTinSP_TabLayout);
        thongTinSPViewPage = findViewById(R.id.thongTinSP_ViewPage);
        danhgiaLayout=findViewById(R.id.rate_order_container);
        buyNowBtn = findViewById(R.id.buy_now_btn);


        //xử lý
        List<Integer> lstAnhSP=new ArrayList<>();
        lstAnhSP.add(R.mipmap.quanao1);
        lstAnhSP.add(R.mipmap.quanao2);
        lstAnhSP.add(R.mipmap.quanao3);

        ImageSPAdapterViewPage anhSPAdapter = new ImageSPAdapterViewPage(lstAnhSP);
        imageSanphamViewPage.setAdapter(anhSPAdapter);

        soluongAnhSp.setupWithViewPager(imageSanphamViewPage,true);

        //btn Yeu thich
        btnThemVaoYeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(themVaoYeuThich){
                    themVaoYeuThich=false;
                    btnThemVaoYeuThich.setSupportImageTintList(getResources().getColorStateList(R.color.colorTrang));
                }else{
                    themVaoYeuThich=true;
                    btnThemVaoYeuThich.setSupportImageTintList(getResources().getColorStateList(R.color.colorThatBai));
                }
            }
        });

        //phần tt SP
        thongTinSPViewPage.setAdapter(new ThongTinSanPhamAdapter(getSupportFragmentManager(),thongTinSPTabLayout.getTabCount()));
        thongTinSPViewPage.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(thongTinSPTabLayout));
        thongTinSPTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                thongTinSPViewPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //phần đánh giá
        for(int i=0;i<danhgiaLayout.getChildCount();i++){
            final int starPosition=i;
            danhgiaLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SetRating(starPosition);
                }
            });

        }

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delliverIntent = new Intent(SanPhamActivity.this, DelivertyActivity.class);
                startActivity(delliverIntent);
            }
        });
    }


    @SuppressLint("NewApi")
    private void SetRating(int starPosition) {
        for(int i=0;i<danhgiaLayout.getChildCount();i++){
        ImageView starBtn= (ImageView) danhgiaLayout.getChildAt(i);
        starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#D9D6DC")));
        if(i<=starPosition){
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#6200EE")));
        }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id== R.id.mnuTimKiem){
            Toast.makeText(this,"mnuTimKiem",Toast.LENGTH_SHORT).show();
            return true;
        }if(id== R.id.mnuGioHang){
           // Toast.makeText(this,"mnuGioHang",Toast.LENGTH_SHORT).show();
            Intent cartIntent=new Intent(SanPhamActivity.this, TrangChuActivity.class);
            TrangChuActivity.showCart=true;
            startActivity(cartIntent);

            return true;
        }if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            imageSanphamViewPage.setCurrentItem(imageSanphamViewPage.getCurrentItem()+1);
        }
    };



}