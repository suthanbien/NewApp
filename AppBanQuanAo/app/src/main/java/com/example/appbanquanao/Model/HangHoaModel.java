package com.example.appbanquanao.Model;

public class HangHoaModel {
    private int hinhAnh;
    private String ten;
    private String mota;
    private String gia;

    public HangHoaModel() {
    }

    public HangHoaModel(int hinhAnh, String ten, String mota, String gia) {
        this.hinhAnh = hinhAnh;
        this.ten = ten;
        this.mota = mota;
        this.gia = gia;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
