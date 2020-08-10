package com.example.appbanquanao.Model;

public class OrderModel {
    private int anhSP;
    private String tenSP;
    private String tinhTrang;
    private int tinhTrangAnh;
    private int danhGia;

    public OrderModel(int anhSP, String tenSP, String tinhTrang, int tinhTrangAnh, int danhGia) {
        this.anhSP = anhSP;
        this.tenSP = tenSP;
        this.tinhTrang = tinhTrang;
        this.tinhTrangAnh = tinhTrangAnh;
        this.danhGia = danhGia;
    }

    public int getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(int danhGia) {
        this.danhGia = danhGia;
    }

    public int getTinhTrangAnh() {
        return tinhTrangAnh;
    }

    public void setTinhTrangAnh(int tinhTrangAnh) {
        this.tinhTrangAnh = tinhTrangAnh;
    }

    public int getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(int anhSP) {
        this.anhSP = anhSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
