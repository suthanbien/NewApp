package com.example.appbanquanao.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanquanao.DAO.ConnectionClass;
import com.example.appbanquanao.R;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuenMKFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuenMKFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String matKhau;
    private String emailLayMK;
    private FrameLayout frameLayout;
    private EditText edtQuenMk;
    private Button btnXacNhanLayMK;
    private TextView txtQuayLai;
    private LinearLayout layMKEmailContainer;
    private ImageView layMKIcon;
    private TextView txtLayMKEmail;
    private ProgressBar progressbarLayMK;





    public QuenMKFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuenMKFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuenMKFragment newInstance(String param1, String param2) {
        QuenMKFragment fragment = new QuenMKFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quen_m_k, container, false);
        frameLayout=getActivity().findViewById(R.id.FrameLayout_DangKy);

        edtQuenMk = view.findViewById(R.id.edtQuenMk);
        btnXacNhanLayMK = view.findViewById(R.id.btnXacNhanLayMK);
        txtQuayLai = view.findViewById(R.id.txtQuayLai);
        layMKEmailContainer = view.findViewById(R.id.layMK_Email_Container);
        layMKIcon = view.findViewById(R.id.layMK_Icon);
        txtLayMKEmail = view.findViewById(R.id.txtLayMK_email);
        progressbarLayMK = view.findViewById(R.id.progressbarLayMK);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetFragment(new DangNhapFragment());
            }
        });

        edtQuenMk.addTextChangedListener(new TextWatcher() {
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

        btnXacNhanLayMK.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(layMKEmailContainer);
                txtLayMKEmail.setVisibility(View.GONE);

                TransitionManager.beginDelayedTransition(layMKEmailContainer);
                layMKIcon.setVisibility(View.VISIBLE);
                progressbarLayMK.setVisibility(View.VISIBLE);
                btnXacNhanLayMK.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
                btnXacNhanLayMK.setEnabled(false);

                ThucThiLayMK();

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

    private void CheckInput(){
        if(!TextUtils.isEmpty(edtQuenMk.getText())){
            btnXacNhanLayMK.setTextColor(getResources().getColor(R.color.colorTrang));
            btnXacNhanLayMK.setEnabled(true);
        }else{
            btnXacNhanLayMK.setTextColor(getResources().getColor(R.color.colorVoHieuHoa));
            btnXacNhanLayMK.setEnabled(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void ThucThiLayMK(){
        String username;
        username=edtQuenMk.getText().toString();

        if(KiemTraTK(username)){
            if(KiemTraEmail(username)){
                if(SendMail(matKhau,emailLayMK.trim())){

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 500ms
                            // Toast.makeText(getActivity(),"Lấy lại MK thành Công",Toast.LENGTH_SHORT).show();
                            TransitionManager.beginDelayedTransition(layMKEmailContainer);
                            // layMKIcon.setVisibility(View.GONE);
                            progressbarLayMK.setVisibility(View.GONE);
                            txtLayMKEmail.setTextColor(getResources().getColor(R.color.colorHoanTat));
                            txtLayMKEmail.setText(getResources().getString(R.string.lay_MK_ThanhCong));
                            txtLayMKEmail.setVisibility(View.VISIBLE);
                        }
                    }, 5000);


                }else{
                  //  Toast.makeText(getActivity(),"Lấy lại MK thất bại",Toast.LENGTH_SHORT).show();
                    TransitionManager.beginDelayedTransition(layMKEmailContainer);
                   // layMKIcon.setVisibility(View.GONE);
                    progressbarLayMK.setVisibility(View.GONE);
                    txtLayMKEmail.setTextColor(getResources().getColor(R.color.colorThatBai));
                    txtLayMKEmail.setText(getResources().getString(R.string.lay_MK_ThatBai));
                    txtLayMKEmail.setVisibility(View.VISIBLE);
                }

            }else{
               // edtQuenMk.setError(getResources().getString(R.string.tai_khoan_chua_xac_nhan_email));
                TransitionManager.beginDelayedTransition(layMKEmailContainer);
               // layMKIcon.setVisibility(View.GONE);
                progressbarLayMK.setVisibility(View.GONE);
                txtLayMKEmail.setTextColor(getResources().getColor(R.color.colorThatBai));
                txtLayMKEmail.setText(getResources().getString(R.string.tai_khoan_chua_xac_nhan_email));
                txtLayMKEmail.setVisibility(View.VISIBLE);
            }
        }else{
           // edtQuenMk.setError(getResources().getString(R.string.ten_dang_nhap_khong_dung));
            TransitionManager.beginDelayedTransition(layMKEmailContainer);
            //layMKIcon.setVisibility(View.GONE);
            progressbarLayMK.setVisibility(View.GONE);
            txtLayMKEmail.setTextColor(getResources().getColor(R.color.colorThatBai));
            txtLayMKEmail.setText(getResources().getString(R.string.ten_dang_nhap_khong_dung));
            txtLayMKEmail.setVisibility(View.VISIBLE);
        }

    }

    private boolean KiemTraTK(String username){
        boolean ketqua=false;
        String sql="select * from TaiKhoanKhachHang " +
                " inner join KhachHang on KhachHang.MaKhachHang=TaiKhoanKhachHang.MaKhachHang " +
                " where " +
                " TenDangNhap='"+username+"' or Email='"+username+"' ";
        ConnectionClass con=new ConnectionClass();
        ResultSet rs= con.GetTableResult(sql);
        try {
            if (rs.next()) {
                //Log.e("ERROR","Kiểm Tra Mail "+ emailLayMK);
                ketqua=true;
            }
        } catch (SQLException ex) {
            Log.e("ERROR","Kiểm Tra TK lỗi "+ ex.getMessage());
        }
        return ketqua;
    }
    private boolean KiemTraEmail(String username){
        boolean ketqua=false;
        String sql="select Email,TenDangNhap,Password from TaiKhoanKhachHang " +
                " inner join KhachHang on KhachHang.MaKhachHang=TaiKhoanKhachHang.MaKhachHang " +
                " where " +
                " Email='"+username+"' or TenDangNhap='"+username+"'" +
                " group by Email,TenDangNhap,Password" +
                " having not Email='NULL'";
        ConnectionClass con=new ConnectionClass();
        ResultSet rs= con.GetTableResult(sql);
        try {
            if (rs.next()) {
                matKhau=rs.getString("Password");
                emailLayMK=rs.getString("Email");
                //Log.e("ERROR","Kiểm Tra Mail "+ emailLayMK);
                ketqua=true;
            }
        } catch (SQLException ex) {
            Log.e("ERROR","Kiểm Tra Mail lỗi "+ ex.getMessage());
        }
        return ketqua;
    }
    private boolean SendMail(String matKhauMail,String email){
        boolean ketqua=false;
        try {
        String sql="EXEC msdb.dbo.sp_send_dbmail  " +
                "@profile_name = 'Babymilo App',  " +
                "@recipients = '"+email+"',  " +
                "@subject = N'Xác nhận lấy lại mật khẩu Babymilo App',  " +
                "@body = N'Mật khẩu cho tài khoản Babymilo App của bạn là: "+matKhauMail+"'; ";

          //  Log.e("ERROR","Câu lệnh:"+sql);
         ConnectionClass con=new ConnectionClass();
         con.ExecuteQuery(sql);
         ketqua=true;
        } catch (Exception ex) {
            Log.e("ERROR","Gửi Mail lỗi "+ ex.getMessage());
            ketqua=false;
        }
        return ketqua;
    }
}