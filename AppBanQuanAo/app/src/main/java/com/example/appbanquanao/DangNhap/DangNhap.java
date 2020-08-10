package com.example.appbanquanao.DangNhap;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanquanao.Fragment.DangNhapFragment;
import com.example.appbanquanao.R;

public class DangNhap extends AppCompatActivity {
    private FrameLayout frameLayout;
    public static boolean onQuenMKFragment=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        frameLayout=findViewById(R.id.FrameLayout_DangKy);
        SetDefaultFragment(new DangNhapFragment());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(onQuenMKFragment){
                onQuenMKFragment=false;
               SetFragment(new DangNhapFragment());
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    private void SetDefaultFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slydeout_from_right);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

}
