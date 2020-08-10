package com.example.appbanquanao.DAO;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClass {
    //static String ip = "192.168.1.7"; //long
    //static String ip = "192.168.1.9"; //quy
    //static String ip = "192.168.128.195"; //server1
   // static String ip = "192.168.1.4"; huong
    static String ip = "192.168.1.5"; //xiu

    static String classs = "net.sourceforge.jtds.jdbc.Driver"; //khóa này không thay đổi
    static String db = "QuanLySanPham";//tên database
    static String un = "sqlserver"; //user đăng nhập
    static String password = "113114115";// mật khẩu đăng nhập
    static String z;
    static Boolean isSuccess;
    private Connection connection;

    @SuppressLint("NewApi")
    public static Connection Connect(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip +";databaseName="+ db + ";user=" + un+ ";password=" + password + ";";
            //ConnURL="jdbc:mysql://{hostname}:{port}"
            conn = DriverManager.getConnection(ConnURL);
            ///Connection conn2 = DriverManager.getConnection(url, username, password);
           // Log.e("ERROR","Kết Nối Thành Công ");

        } catch (SQLException se) {
            Log.e("ERROR1","Không thể tải lớp Driver! "+ se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR2","Xuất hiện vấn đề truy cập trong khi tải! "+ e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR3", "Không thể khởi tạo Driver! "+e.getMessage());
        }
        return conn;
    }

    public ConnectionClass() {
       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip +";databaseName="+ db + ";user=" + un+ ";password=" + password + ";";
            //ConnURL="jdbc:mysql://{hostname}:{port}"
            conn = DriverManager.getConnection(ConnURL);
            connection= DriverManager.getConnection(ConnURL);
           // Log.e("ERROR","Kết Nối Thành Công ");

        } catch (SQLException se) {
            Log.e("ERROR1","Không thể tải lớp Driver! "+ se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR2","Xuất hiện vấn đề truy cập trong khi tải! "+ e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR3", "Không thể khởi tạo Driver! "+e.getMessage());
        }
    }


    public void CloseConnect(){  //tạo phương thức Đóng kết nối
        try{  //thử nếu không lỗi
            if(connection!=null){   //nếu đang kết nối
                connection.close();  // đóng
            }
        }
        catch (Exception ex){  //nếu lỗi
            //không làm gì cả
        }
    }

    //Thực thi câu lệnh SELECT
    public ResultSet GetTableResult(String cauTruyVanSQL){
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;

        } catch (SQLException ex) {
            Log.e("ERROR","lỗi thực thi câu lệnh SELECT: "+ ex.getMessage());
        }
        return null;
    }

   //Thực thi INSERT UPDATE
    public void UpdateDatabase(String cauLenhUpdate){

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(cauLenhUpdate);
        } catch (SQLException ex) {
            Log.e("ERROR","lỗi Thực thi INSERT UPDATE: "+ ex.getMessage());
        }
    }
    //Thực thi ExecuteQuery
    public void ExecuteQuery(String cauLenhUpdate){

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(cauLenhUpdate);
        } catch (SQLException ex) {
            Log.e("ERROR","lỗi Thực thi ExecuteQuery: "+ ex.getMessage());
        }
    }
    /*

    //Thực thi  DELETE,
    public void ExcuteQueryDeleteDB(String cauTruyVanSQL,String tenmuonXoa){

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
            ThongBao("Xóa Thành Công Đối Tượng : "+tenmuonXoa, "Thông Báo", 2);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            ThongBao("Bạn không thể xóa đối tượng này với bất kỳ Quyền nào","Cảnh Báo",2);
        }
    }
    public boolean Tim(String sql) throws SQLException {
        Statement stmt =connection.createStatement();
        ResultSet rs= stmt.executeQuery(sql); //chạy câu lệnh và truyền vào sr. nghĩa là nó lấy dữ liệu ra và truyền trở lại sr
        int i=0;
        while (rs.next()){  //trong khi sr.next. có nghĩa là sr có phần tử. nghĩa là đã tìm thấy khóa
            i=i+1;     //thì i cộng 1
        }
        if(i>0){   // nếu i>0

            return true;  //trả về true. ngĩa là đã tìm thấy
        }
        return false;   // ngược lại không tìm thấy
    }

    public ResultSet Tim_MSSanPham(String msSanPham) throws SQLException {
        Statement stmt =connection.createStatement();
        String sql="select * from SanPham where MaSanPham="+msSanPham;
        ResultSet rs= stmt.executeQuery(sql);
        return rs;
    }
    public ResultSet Tim_TenSanPham(String tenSanPham) throws SQLException {
        Statement stmt =connection.createStatement();
        String sql="select * from SanPham where TenSanPham=N'"+tenSanPham+"'";
        ResultSet rs= stmt.executeQuery(sql);
        return rs;
    }
    public void Them_HoaDon(String maKhachHang, String maNhanVien, String ngay,float TongGia) throws SQLException {
        Statement stmt =connection.createStatement();
        String sql= " insert into HoaDon values ("+maKhachHang+","+maNhanVien+",'"+ngay+"',"+TongGia+",'')";
        //System.out.println(sql);
        stmt.executeUpdate(sql);
    }
    public void Them_ChiTietHoaDon(String maHD, String maSP, float sl, float tongTien) throws SQLException {
        Statement stmt =connection.createStatement();
        String sql= " insert into ChiTietHoaDon values ("+maHD+","+maSP+","+sl+","+tongTien+",'')";
        //System.out.println(sql);
        stmt.executeUpdate(sql);
    }

    public ResultSet Tim_SoHoaDon(String shd) throws SQLException {
        Statement stmt =connection.createStatement();
        String sql="select MaHoaDon from HoaDon where MaHoaDon='" +shd+"'"   ;
        ResultSet rs= null;
        rs=  stmt.executeQuery(sql);
        return rs;
    }*/
}
