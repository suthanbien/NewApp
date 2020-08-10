package com.example.appbanquanao.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanquanao.Activity.TrangChuActivity;
import com.example.appbanquanao.DAO.ConnectionClass;
import com.example.appbanquanao.R;

import java.sql.ResultSet;
import java.sql.SQLException;

import static android.content.Context.MODE_PRIVATE;
import static com.example.appbanquanao.DangNhap.DangNhap.onQuenMKFragment;


public class DangNhapFragment extends Fragment {
 public DangNhapFragment() {

    }


    private FrameLayout frameLayout;
    private ImageButton btnDongDN;
    private ImageView imageViewDN;
    private EditText edtTaiKhoan;
    private EditText edtMatKhau;
    private TextView txtQuenMK;
    private Button btnDangNhap;
    private TextView txtKhongCoTK;
    private ProgressBar progressBarDangNhap;
    SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dang_nhap, container, false);

        txtKhongCoTK=view.findViewById(R.id.txtKhongCoTK);
        frameLayout=getActivity().findViewById(R.id.FrameLayout_DangKy);
        btnDongDN = view.findViewById(R.id.btnDong_DN);
        imageViewDN = view.findViewById(R.id.imageView_DN);
        edtTaiKhoan = view.findViewById(R.id.edtTaiKhoan);
        edtMatKhau = view.findViewById(R.id.edtMatKhau);
        txtQuenMK = view.findViewById(R.id.txtQuenMK);
        btnDangNhap = view.findViewById(R.id.btnDangNhap);
        txtKhongCoTK = view.findViewById(R.id.txtKhongCoTK);
        progressBarDangNhap = view.findViewById(R.id.progressBar_DangNhap);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        boolean isLogin=false;
        sharedPreferences=getActivity().getSharedPreferences("loginData",MODE_PRIVATE);
        edtTaiKhoan.setText(sharedPreferences.getString("taiKhoan",""));
        edtMatKhau.setText(sharedPreferences.getString("matKhau",""));
        isLogin=sharedPreferences.getBoolean("trangThai",false);
        if(isLogin){
            XuLyDangNhap();
        }

        txtKhongCoTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
                onQuenMKFragment=true;
                SetFragment(new DangKyFragment());
            }
        });

        txtQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 onQuenMKFragment=true;
                SetFragment(new QuenMKFragment());
            }
        });

        edtTaiKhoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            CheckInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtMatKhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CheckInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyDangNhap();
            }
        });
    }

    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void CheckInput(){
        if(!TextUtils.isEmpty(edtTaiKhoan.getText())){
            if(!TextUtils.isEmpty(edtMatKhau.getText())){
                btnDangNhap.setTextColor(getResources().getColor(R.color.colorTrang));
                btnDangNhap.setEnabled(true);
            }else{
                btnDangNhap.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
                btnDangNhap.setEnabled(false);
            }
        }else{
            btnDangNhap.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
            btnDangNhap.setEnabled(false);
        }
    }
    private void XuLyDangNhap(){
        progressBarDangNhap.setVisibility(View.VISIBLE);// mở khóa progressbar
        btnDangNhap.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
        btnDangNhap.setEnabled(false);
        final String  username, password;

        username=edtTaiKhoan.getText().toString();
        password=edtMatKhau.getText().toString();
        /*if(kiemTraDangNhap(username,password)){

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 500ms
                    // Toast.makeText(getActivity(),"Đăng Nhập Thành Công",Toast.LENGTH_SHORT).show();
                    Intent trangChuIntent = new Intent(getActivity(), TrangChuActivity.class);
                    startActivity(trangChuIntent);
                    getActivity().finish();
                    // progressBar.setVisibility(View.INVISIBLE);

                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.putString("taiKhoan",username);
                    editor.putString("matKhau",password);
                    editor.putBoolean("trangThai",true);

                    editor.commit();

                    btnDangNhap.setTextColor(getResources().getColor(R.color.colorTrang));
                    btnDangNhap.setEnabled(true);
                }
            }, 2000);

        }else{
            //Toast.makeText(getActivity(),"tạo TK Thất Bại",Toast.LENGTH_SHORT).show();
            //edtTaiKhoan.setError(getResources().getString(R.string.tenDM_hoacMK_khong_dung));
            edtMatKhau.setError(getResources().getString(R.string.tenDM_hoacMK_khong_dung));
            progressBarDangNhap.setVisibility(View.INVISIBLE);
            btnDangNhap.setTextColor(getResources().getColor(R.color.colorTrang));
            btnDangNhap.setEnabled(true);
        }*/
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 500ms
                // Toast.makeText(getActivity(),"Đăng Nhập Thành Công",Toast.LENGTH_SHORT).show();
                Intent trangChuIntent = new Intent(getActivity(), TrangChuActivity.class);
                startActivity(trangChuIntent);
                getActivity().finish();
                // progressBar.setVisibility(View.INVISIBLE);

                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("taiKhoan",username);
                editor.putString("matKhau",password);
                editor.putBoolean("trangThai",true);

                editor.commit();

                btnDangNhap.setTextColor(getResources().getColor(R.color.colorTrang));
                btnDangNhap.setEnabled(true);
            }
        }, 2000);

    }
    public boolean kiemTraDangNhap(String username,String password){
        boolean ketqua=false;
        String sql="select * from TaiKhoanKhachHang " +
                " inner join KhachHang on KhachHang.MaKhachHang=TaiKhoanKhachHang.MaKhachHang" +
                " where" +
                " TenDangNhap='"+username+"' and Password='"+password+"' " +
                " or Email='"+username+"' and Password='"+password+"'";


        ConnectionClass con=new ConnectionClass();
        ResultSet rs= con.GetTableResult(sql);
        try {
            if (rs.next()) {
              /*  quyen = rs.getInt("Quyen");
                // String tennv=rs.getString("TenNhanVien");
                user=rs.getString("TenDangNhap");
                // System.out.println(" " + quyen);*/
                ketqua=true;
                con.CloseConnect();
            }
        } catch (SQLException ex) {
            Log.e("ERROR","Lỗi Đăng Nhập! "+ ex.getMessage());
        }
        return ketqua;
    }
}
