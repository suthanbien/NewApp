package com.example.appbanquanao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Adapter.GioHangAdapter;
import com.example.appbanquanao.Model.GioHangItemModel;
import com.example.appbanquanao.R;

import java.util.ArrayList;
import java.util.List;

public class DelivertyActivity extends AppCompatActivity {
    private RecyclerView deliveryRecycleView;
    private LinearLayout linearLayoutDelivery;
    private Button deliveryContinuteBtn;
    private Button buttonChangOrAddAress;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverty);

        Toolbar toolbar = findViewById(R.id.toolbar_deliverty);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delyvery");

        deliveryRecycleView = findViewById(R.id.delivery_RecycleView);
        linearLayoutDelivery = findViewById(R.id.linearLayout_Delivery);
        deliveryContinuteBtn = findViewById(R.id.delivery_continute_btn);
        buttonChangOrAddAress = findViewById(R.id.button_chang_or_add_aress);




        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecycleView.setLayoutManager(layoutManager);

        List<GioHangItemModel> lstGioHangItemModel=new ArrayList<>();
        lstGioHangItemModel.add(new GioHangItemModel(0, R.mipmap.quanao1,"Quần què 1",2,"200.000","500.000",1,0,3));
        lstGioHangItemModel.add(new GioHangItemModel(0, R.mipmap.quanao2,"Quần què 2",3,"400.000","700.000",2,1,4));
        lstGioHangItemModel.add(new GioHangItemModel(0, R.mipmap.quanao3,"Quần què 3",4,"600.000","900.000",3,2,5));
        lstGioHangItemModel.add(new GioHangItemModel(1,"Price 3 Item","1600000","free","2600000","2500000"));

        GioHangAdapter gioHangAdapter=new GioHangAdapter(lstGioHangItemModel);
        deliveryRecycleView.setAdapter(gioHangAdapter);
        gioHangAdapter.notifyDataSetChanged();

        deliveryContinuteBtn.setVisibility(View.VISIBLE);
        deliveryContinuteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonChangOrAddAress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddressActivity = new Intent(DelivertyActivity.this, AddressActivity.class);
                startActivity(AddressActivity);
            }
        });
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