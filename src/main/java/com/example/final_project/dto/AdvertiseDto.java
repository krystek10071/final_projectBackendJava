package com.example.final_project.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
public class AdvertiseDto {

    private long id;
    private String title;
    private int price;
    private String location;
    private String province;
    private String contactNumber;
    private String description;
    private String category;
    private Date timeAdd;

    public long getId() {
        return id;
    }

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

    public Date getTimeAdd() {
        return timeAdd;
    }


}
