package com.example.appbanquanao.Fragment;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanquanao.Activity.KhoiDongActivity;
import com.example.appbanquanao.DAO.ConnectionClass;
import com.example.appbanquanao.R;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * A simple {@link Fragment} subclass.
 */
public class DangKyFragment extends Fragment {

    public DangKyFragment() {
        // Required empty public constructor
    }



    private FrameLayout frameLayout;
    private Button btnDangKy;
    private ImageButton btnDongDK;
    private ImageView imageViewDK;
    private EditText edtHoVaTenDK;
    private EditText edtMatKhauDK;
    private EditText edtNhapLaiMatKhauDK;
    private EditText edtTaiKhoanDK;
    private TextView txtCoTKDK;
    private ProgressBar progressBar;


   // private String emailHopLe="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dang_ky, container, false);


        frameLayout=getActivity().findViewById(R.id.FrameLayout_DangKy);

        btnDangKy = view.findViewById(R.id.btnDangKy);
        btnDongDK = view.findViewById(R.id.btnDongDK);
        imageViewDK = view.findViewById(R.id.imageView_DK);
        edtHoVaTenDK = view.findViewById(R.id.edtHoVaTenDK);
        edtMatKhauDK = view.findViewById(R.id.edtMatKhauDK);
        edtNhapLaiMatKhauDK = view.findViewById(R.id.edtNhapLaiMatKhauDK);
        edtTaiKhoanDK = view.findViewById(R.id.edtTaiKhoanDK);
        txtCoTKDK = view.findViewById(R.id.txtCoTKDK);
        progressBar = view.findViewById(R.id.progressBar);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //co tài khoản click
        txtCoTKDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                SetFragment(new DangNhapFragment());
            }
        });

        //kiểm tra text change của các edit text
        edtTaiKhoanDK.addTextChangedListener(new TextWatcher() {
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
        edtHoVaTenDK.addTextChangedListener(new TextWatcher() {
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
        edtMatKhauDK.addTextChangedListener(new TextWatcher() {
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
        edtNhapLaiMatKhauDK.addTextChangedListener(new TextWatcher() {
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



        //Đăng ký click
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gửi dữ liệu đến csdl
                XuLyDangKy();
            }
        });
    }


    // thay đổi fragment
    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slydeout_from_right);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    //Kiem tra giá trị nhập đủ điều kiện hay không
    private void CheckInput(){
        if(!TextUtils.isEmpty(edtTaiKhoanDK.getText())){
            if(!TextUtils.isEmpty(edtHoVaTenDK.getText())){
                if(!TextUtils.isEmpty(edtMatKhauDK.getText())&& edtNhapLaiMatKhauDK.length()>=8){
                    if(!TextUtils.isEmpty(edtNhapLaiMatKhauDK.getText())){
                        btnDangKy.setTextColor(getResources().getColor(R.color.colorTrang));
                        btnDangKy.setEnabled(true);
                    }
                    else{
                        btnDangKy.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
                        btnDangKy.setEnabled(false);
                    }
                }else{
                    btnDangKy.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
                    btnDangKy.setEnabled(false);
                }
            }else{
                btnDangKy.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
                btnDangKy.setEnabled(false);
            }
        }else{
            btnDangKy.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
            btnDangKy.setEnabled(false);
        }
    }
    private void XuLyDangKy(){
        if(!KiemTraMail(edtTaiKhoanDK.getText().toString())  ){
            progressBar.setVisibility(View.VISIBLE);// mở khóa progressbar
            btnDangKy.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
            btnDangKy.setEnabled(false);
            //thực thi tạo tk
            //Toast.makeText(getActivity(),"tạo TK Thành Công",Toast.LENGTH_SHORT).show();
            String hoTen, username, password;
            hoTen=edtHoVaTenDK.getText().toString();
            username=edtTaiKhoanDK.getText().toString();
            password=edtMatKhauDK.getText().toString();

            if(edtMatKhauDK.getText().toString().equals(edtNhapLaiMatKhauDK.getText().toString())){
                if(DangKy(hoTen, username, password)){
                    //Toast.makeText(getActivity(),"Tạo TK Thành Công",Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(getActivity(), KhoiDongActivity.class);
                    startActivity(mainIntent);
                    getActivity().finish();
                }
                else{
                    Toast.makeText(getActivity(),"Tạo TK Thất Bại",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);

                }
            }else{
                edtNhapLaiMatKhauDK.setError(getResources().getString(R.string.mat_khau_nhap_lai_khong_dung));
                btnDangKy.setTextColor(getResources().getColor(R.color.colorTrang));
                btnDangKy.setEnabled(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
        }else{
            //Toast.makeText(getActivity(),"tạo TK Thất Bại",Toast.LENGTH_SHORT).show();
            edtTaiKhoanDK.setError(getResources().getString(R.string.tai_khoan_dk_da_co));
           // progressBar.setVisibility(View.INVISIBLE);
            btnDangKy.setTextColor(getResources().getColor(R.color.colorTrang));
            btnDangKy.setEnabled(true);
        }
    }
    private boolean KiemTraMail(String username){
        boolean ketqua=false;
        String sql="select * from TaiKhoanKhachHang " +
                " inner join KhachHang on KhachHang.MaKhachHang=TaiKhoanKhachHang.MaKhachHang " +
                " where " +
                " TenDangNhap='"+username+"' or Email='"+username+"' ";
        ConnectionClass con=new ConnectionClass();
        ResultSet rs= con.GetTableResult(sql);
        try {
            if (rs.next()) {
              /*  quyen = rs.getInt("Quyen");
                // String tennv=rs.getString("TenNhanVien");
                user=rs.getString("TenDangNhap");
                // System.out.println(" " + quyen);*/
                ketqua=true;
            }
        } catch (SQLException ex) {
            Log.e("ERROR","Kiểm Tra Mail lỗi "+ ex.getMessage());
        }
        return ketqua;
    }
    private boolean DangKy(String hoTen,String username,String password){
        boolean ketqua=false;
        try {
        String cauLenhDangKy="BEGIN TRANSACTION " +
                "BEGIN TRY " +
                "   DECLARE @DataID int; " +
                "   INSERT INTO KhachHang(TenKhachHang,LoaiKhachHang) VALUES (N'"+hoTen+"',2); " +
                "   SELECT @DataID = scope_identity(); " +
                "   INSERT INTO TaiKhoanKhachHang VALUES ( @DataID,'"+username+"'" +
                ",'"+password+"',NULL,NULL); " +
                "COMMIT " +
                "END TRY " +
                "BEGIN CATCH " +
                "ROLLBACK " +
                "END CATCH";
            ConnectionClass con=new ConnectionClass();
            con.UpdateDatabase(cauLenhDangKy);
            ketqua=true;
        } catch (Exception ex) {
            Log.e("ERROR","Đăng ký lỗi: "+ ex.getMessage());
        }
        return ketqua;
    }

}
