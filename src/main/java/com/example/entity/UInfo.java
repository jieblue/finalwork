package com.example.entity;

import org.springframework.web.multipart.MultipartFile;

public class UInfo {
    private String code;
    private String nickname;
    private MultipartFile file;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "UInfo{" +
                "code='" + code + '\'' +
                ", nickname='" + nickname + '\'' +
                ", file=" + file +
                '}';
    }
}
