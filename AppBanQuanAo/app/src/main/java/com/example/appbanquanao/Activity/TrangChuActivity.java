package com.example.appbanquanao.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appbanquanao.R;
import com.google.android.material.navigation.NavigationView;

public class
TrangChuActivity extends AppCompatActivity {

    private static final int HOME_FRAGMENT=0;
    private static final int CART_FRAGMENT=1;
    public static Boolean showCart=false;

    private static  int currentFragment;
    private NavigationView navigationView;

    private AppBarConfiguration mAppBarConfiguration;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
         navigationView = findViewById(R.id.nav_view);

        //navigationView.getMenu().getItem(0).setChecked(true);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_trang_chu,
                R.id.nav_ma_giam_gia,
                R.id.nav_don_hang,
                R.id.nav_tai_khoan,
                R.id.nav_yeu_thich,
                R.id.nav_gio_hang)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        if(showCart){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            Navigation.findNavController(this, R.id.nav_host_fragment).navigate( R.id.nav_gio_hang);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       if(currentFragment==HOME_FRAGMENT){
           getMenuInflater().inflate(R.menu.main, menu);
       }
        if (currentFragment == CART_FRAGMENT)
        {
            for (int i = 0; i < menu.size(); i++)
                menu.getItem(i).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(showCart){
            showCart=false;
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id== R.id.mnuGioHang){
            //Toast.makeText(this,"mnuGioHang",Toast.LENGTH_SHORT).show();
            Navigation.findNavController(this, R.id.nav_host_fragment).navigate( R.id.nav_gio_hang);
            currentFragment=CART_FRAGMENT;
            //invalidateOptionsMenu();

            return true;
        }else if(id== R.id.mnuThongBao){
            Toast.makeText(this,"mnuThongBao",Toast.LENGTH_SHORT).show();
            return true;
        }else if(id== R.id.mnuTimKiem){
            Toast.makeText(this,"mnuTimKiem",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}