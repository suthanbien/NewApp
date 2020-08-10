package com.example.appbanquanao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appbanquanao.R;

public class AddressActivity extends AppCompatActivity {
    private Button buttonAddressSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Toolbar toolbar = findViewById(R.id.toolbar_address);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Add a new address");


        buttonAddressSave = findViewById(R.id.button_Address_Save);
        buttonAddressSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delliverIntent = new Intent(AddressActivity.this, DelivertyActivity.class);
                startActivity(delliverIntent);
                finish();
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