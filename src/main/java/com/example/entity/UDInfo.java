package com.example.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class UDInfo implements Serializable {
    private  Integer id;
    private MultipartFile file;
    private String url;
    private String smallurl;

    public String getSmallurl() {
        return smallurl;
    }

    public void setSmallurl(String smallurl) {
        this.smallurl = smallurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UDInfo{" +
                "id=" + id +
                ", file=" + file +
                ", url='" + url + '\'' +
                '}';
    }
}
