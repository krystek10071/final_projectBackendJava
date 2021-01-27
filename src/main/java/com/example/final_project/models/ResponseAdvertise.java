package com.example.final_project.models;

import com.sun.istack.NotNull;

import java.util.Date;

public class ResponseAdvertise {

    private long id;
    private String title;
    private int price;
    private String location;
    private String category;
    private Date timeAdd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public ResponseAdvertise(long id, String title, int price, String location, String category, Date timeAdd) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.location = location;
        this.category = category;
        this.timeAdd = timeAdd;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(Date timeAdd) {
        this.timeAdd = timeAdd;
    }
}
