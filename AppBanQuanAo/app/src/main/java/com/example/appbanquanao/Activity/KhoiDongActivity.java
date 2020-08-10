package com.example.appbanquanao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbanquanao.DangNhap.DangNhap;
import com.example.appbanquanao.R;

import java.sql.ResultSet;


public class KhoiDongActivity extends AppCompatActivity {
    ResultSet resultSet;
    String r="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoidong);

        SystemClock.sleep(3000);
        Intent dangKyIntent =new Intent(KhoiDongActivity.this, DangNhap.class);
        startActivity(dangKyIntent);

        finish();
    }
}
