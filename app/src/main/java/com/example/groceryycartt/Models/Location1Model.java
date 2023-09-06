package com.example.groceryycartt.Models;

public class Location1Model {
    int image=0;
    String shopname="";
    String shopaddress="";
    String shopephone="";

    public Location1Model(int image, String shopname, String shopaddress, String shopephone) {
        this.image = image;
        this.shopname = shopname;
        this.shopaddress = shopaddress;
        this.shopephone = shopephone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    public String getShopephone() {
        return shopephone;
    }

    public void setShopephone(String shopephone) {
        this.shopephone = shopephone;
    }
}
