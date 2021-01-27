package com.example.final_project.models;

import com.sun.istack.NotNull;

import java.util.Date;

public class Advertise {
    private final String title;
    private final int price;
    private final String location;
    private final String province;
    private final String contactNumber;
    private final String description;
    private final String category;

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getProvince() {
        return province;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }



    public Advertise(String title, int price, String location, String province, String contactNumber, String description, String category) {
        this.title = title;
        this.price = price;
        this.location = location;
        this.province = province;
        this.contactNumber = contactNumber;
        this.description = description;
        this.category = category;
    }
}
