package com.lesehome.sample.module_mvc.model.entity;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;

/**
 * Created by hcp on 16/1/15.
 */
public class Other implements IItemEntity {
    private String name;
    private double price;
    private String time;

    public Other(String name, double price,String time) {
        super();
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
