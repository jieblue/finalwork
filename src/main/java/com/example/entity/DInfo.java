package com.example.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class DInfo implements Serializable {
    private String name;
    private float price;
    private String favor;
    private String category;
    private  String rname;
    private  String rlocation;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRlocation() {
        return rlocation;
    }

    public void setRlocation(String rlocation) {
        this.rlocation = rlocation;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "DInfo{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", favor='" + favor + '\'' +
                ", category='" + category + '\'' +
                ", rname='" + rname + '\'' +
                ", rlocation='" + rlocation + '\'' +
                ", file=" + file +
                '}';
    }
}
