package com.example.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CInfo implements Serializable {
   private String uid;
   private Integer did;
   private float score;

   private String  text;
   MultipartFile file;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }





    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "CInfo{" +
                "uid='" + uid + '\'' +
                ", did=" + did +
                ", score=" + score +
                ", text='" + text + '\'' +
                ", file=" + file +
                '}';
    }
}
