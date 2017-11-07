package com.example.ravi.productapp;

import java.io.Serializable;

/**
 * Created by ravi on 3/11/17.
 */

public class Data implements Serializable {
    String name,price,description;
    int img,index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Data(String name, String price, String description, int imgid) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = imgid;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
