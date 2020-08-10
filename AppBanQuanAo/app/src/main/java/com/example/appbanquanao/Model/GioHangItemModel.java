package com.example.appbanquanao.Model;

public class GioHangItemModel {
    public static final int CART_ITEM=0;
    public static final int TOTAL_AMOUNT=2;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //cart item
    private int productImage;
    private String productTile;
    private int freeCoupont;
    private String productPrice;
    private String cotedPrice;
    private int productQuantity;
    private int offerApplied;
    private int couponsApplied;

    public GioHangItemModel(int type, int productImage, String productTile, int freeCoupont, String productPrice, String cotedPrice, int productQuantity, int offerApplied, int couponsApplied) {
        this.type = type;
        this.productImage = productImage;
        this.productTile = productTile;
        this.freeCoupont = freeCoupont;
        this.productPrice = productPrice;
        this.cotedPrice = cotedPrice;
        this.productQuantity = productQuantity;
        this.offerApplied = offerApplied;
        this.couponsApplied = couponsApplied;
    }

    // cart total
    private String totalItem;
    private String totalItemPrice;
    private String delivertyPrice;
    private String saveAmount;
    private String totalAmount;

    public GioHangItemModel(int type, String totalItem, String totalItemPrice, String delivertyPrice, String saveAmount, String totalAmount) {
        this.type = type;
        this.totalItem = totalItem;
        this.totalItemPrice = totalItemPrice;
        this.delivertyPrice = delivertyPrice;
        this.saveAmount = saveAmount;
        this.totalAmount = totalAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(String totalItem) {
        this.totalItem = totalItem;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalAmount) {
        this.totalItemPrice = totalAmount;
    }

    public String getDelivertyPrice() {
        return delivertyPrice;
    }

    public void setDelivertyPrice(String delivertyPrice) {
        this.delivertyPrice = delivertyPrice;
    }

    public String getSaveAmount() {
        return saveAmount;
    }

    public void setSaveAmount(String saveAmount) {
        this.saveAmount = saveAmount;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTile() {
        return productTile;
    }

    public void setProductTile(String productTile) {
        this.productTile = productTile;
    }

    public int getFreeCoupont() {
        return freeCoupont;
    }

    public void setFreeCoupont(int freeCoupont) {
        this.freeCoupont = freeCoupont;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCotedPrice() {
        return cotedPrice;
    }

    public void setCotedPrice(String cotedPrice) {
        this.cotedPrice = cotedPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(int offerApplied) {
        this.offerApplied = offerApplied;
    }

    public int getCouponsApplied() {
        return couponsApplied;
    }

    public void setCouponsApplied(int couponsApplied) {
        this.couponsApplied = couponsApplied;
    }



}