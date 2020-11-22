package com.example.entity;

import org.springframework.web.multipart.MultipartFile;

public class UInfo {
    private String code;
    private String nickname;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UInfo{" +
                "code='" + code + '\'' +
                ", nickname='" + nickname + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
