package com.example.appbanquanao.Model;

public class MaGiamGiaModel {
    private String maGiamGia;
    private String thoiGian;
    private String noiDung;

    public MaGiamGiaModel(String maGiamGia, String thoiGian, String noiDung) {
        this.maGiamGia = maGiamGia;
        this.thoiGian = thoiGian;
        this.noiDung = noiDung;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
