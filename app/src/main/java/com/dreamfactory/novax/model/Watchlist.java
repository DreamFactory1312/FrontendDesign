package com.dreamfactory.novax.model;

public class Watchlist {

    private int img_product;
    private String txt_product_name,txt_product_price,txt_product_percentage,txt_product_amount,txt_product_share_amount,txt_product_loss,txt_product_loss_weight,type;
    public Watchlist() {
    }

    public Watchlist(int img_product, String txt_product_name, String txt_product_price, String txt_product_percentage, String txt_product_amount, String txt_product_share_amount, String txt_product_loss, String txt_product_loss_weight) {
        this.img_product = img_product;
        this.txt_product_name = txt_product_name;
        this.txt_product_price = txt_product_price;
        this.txt_product_percentage = txt_product_percentage;
        this.txt_product_amount = txt_product_amount;
        this.txt_product_share_amount = txt_product_share_amount;
        this.txt_product_loss = txt_product_loss;
        this.txt_product_loss_weight = txt_product_loss_weight;
    }

    public Watchlist(int img_product, String txt_product_name, String txt_product_price, String txt_product_percentage, String txt_product_amount, String txt_product_share_amount, String type) {
        this.img_product = img_product;
        this.txt_product_name = txt_product_name;
        this.txt_product_price = txt_product_price;
        this.txt_product_percentage = txt_product_percentage;
        this.txt_product_amount = txt_product_amount;
        this.txt_product_share_amount = txt_product_share_amount;
        this.type = type;

    }

    public int getImg_product() {
        return img_product;
    }

    public String getTxt_product_name() {
        return txt_product_name;
    }

    public String getTxt_product_price() {
        return txt_product_price;
    }

    public String getTxt_product_percentage() {
        return txt_product_percentage;
    }

    public String getTxt_product_amount() {
        return txt_product_amount;
    }

    public String getTxt_product_share_amount() {
        return txt_product_share_amount;
    }

    public String getTxt_product_loss() {
        return txt_product_loss;
    }

    public String getTxt_product_loss_weight() {
        return txt_product_loss_weight;
    }

    public String getType() {
        return type;
    }
}
