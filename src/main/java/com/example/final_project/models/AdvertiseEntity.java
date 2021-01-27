package com.example.final_project.models;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Advertise")
public class AdvertiseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @NotNull
    private String title;

    private int price;
    private String location;
    private String province;
    private String contactNumber;
    private String description;
    private String category;
    private Date timeAdd;

    @OneToMany
    @JoinColumn(name = "advertiseId")
    private List<ImageEntity>  images;


    public AdvertiseEntity() {

    }

    public AdvertiseEntity(String title, int price, String location, String province, String contactNumber, String description, String category, Date timeAdd) {
        this.title = title;
        this.price = price;
        this.location = location;
        this.province = province;
        this.contactNumber = contactNumber;
        this.description = description;
        this.category = category;
        this.timeAdd = timeAdd;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getId() {
        return id;
    }
}
