package com.example.appbanquanao.Model;

public class ChiTietSanPhamModel {
    public static final int CHITIET_TITLE=0;
    public static final int CHITIET_BODY=1;

    public int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private String title;

    public ChiTietSanPhamModel(int type, String title) {
        this.type = type;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //phần thân
    private String tieuDe;
    private String noiDung;

    public ChiTietSanPhamModel(int type, String tieuDe, String noiDung) {
        this.type = type;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
