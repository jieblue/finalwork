package com.example.Service;

public interface ZanService {
    Integer dozan(String uid,Integer did,int type);
    int iszan(String uid,Integer did);
    void nozan(Integer id);
}
