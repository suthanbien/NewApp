package com.example.appbanquanao.Model;

public class YeuThichModel {

    private int productImage;
    private String productTitle;
    private int freeCopens;
    private String rating;
    private int totalRating;
    private String productPrice;
    private String cuttedPrice;

    public YeuThichModel(int productImage, String productTitle, int freeCopens, String rating, int totalRating, String productPrice, String cuttedPrice) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCopens = freeCopens;
        this.rating = rating;
        this.totalRating = totalRating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreeCopens() {
        return freeCopens;
    }

    public void setFreeCopens(int freeCopens) {
        this.freeCopens = freeCopens;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedImage) {
        this.cuttedPrice = cuttedImage;
    }

}
