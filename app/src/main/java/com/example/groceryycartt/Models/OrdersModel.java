package com.example.groceryycartt.Models;

public class OrdersModel {
    int image;
    String name,price;

    public OrdersModel(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;

//        this.description = description;
    }




    public OrdersModel() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    }
