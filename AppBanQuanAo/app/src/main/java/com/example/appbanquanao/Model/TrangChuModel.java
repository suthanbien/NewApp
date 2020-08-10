package com.example.appbanquanao.Model;

import java.util.List;

public class TrangChuModel {
    public static final int BANNER_SLIDER =0;
    public static final int STRIP_AD_BANNER =1;
    public static final int HORIZONTAL_PRODUC_VIEW =2;
    public static final int GRID_PRODUC_VIEW =3;
    //phần Banner
    private int type;
    private List<SliderModel>lstSliderModdel;

    public TrangChuModel(int type, List<SliderModel> lstSliderModdel) {
        this.type = type;
        this.lstSliderModdel = lstSliderModdel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getLstSliderModdel() {
        return lstSliderModdel;
    }

    public void setLstSliderModdel(List<SliderModel> lstSliderModdel) {
        this.lstSliderModdel = lstSliderModdel;
    }

    //phần AdBanner
    private int resource;
    private String backgroundColor;

    public TrangChuModel(int type, int resource, String backgroundColor) {
        this.type = type;
        this.resource = resource;
        this.backgroundColor = backgroundColor;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;

    }

    //phần deals of day và treding
    private String title;
    private List<HangHoaModel> lstHangHoaModel;

    public TrangChuModel(int type, String title, List<HangHoaModel> lstHangHoaModel) {
        this.type = type;
        this.title = title;
        this.lstHangHoaModel = lstHangHoaModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HangHoaModel> getLstHangHoaModel() {
        return lstHangHoaModel;
    }

    public void setLstHangHoaModel(List<HangHoaModel> lstHangHoaModel) {
        this.lstHangHoaModel = lstHangHoaModel;
    }

}