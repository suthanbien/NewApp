package com.example.appbanquanao.Model;

public class LoaiSanPhamModel {

    private String iconLSPLink;
    private String tenLoaiSanPham;

    public LoaiSanPhamModel(String iconLSPLink, String tenLoaiSanPham) {
        this.iconLSPLink = iconLSPLink;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public LoaiSanPhamModel() {

    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public String getIconLSPLink() {
        return iconLSPLink;
    }

    public void setIconLSPLink(String iconLSPLink) {
        this.iconLSPLink = iconLSPLink;
    }
}
