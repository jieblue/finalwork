package com.example.controller;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Assert;
import org.junit.Test;

public class Encryptor {

    @Test
    public void getPass() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("EbfYkitulv73I2p0mXI50JMXoaxZTKJ0");
        //String url = textEncryptor.encrypt("jdbc:mysql://150.158.153.134:3306/fzumqldb?serverTimezone=GMT%2b8&useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false");
        String name = textEncryptor.encrypt("wx0f8a86bd3d1c330b");
        String password = textEncryptor.encrypt("eb3295a1c50e18c189485fcff1d9e7c1");
//解密内容
//        String url = textEncryptor.decrypt("");
//        String name = textEncryptor.decrypt("");
//        String password = textEncryptor.decrypt("4EyN0xDLbnP2lsaayjl8fbIctj5bVIdD");


//     //   System.out.println(url + "----------------");
        System.out.println(name + "----------------");
        System.out.println(password + "----------------");
//        Assert.assertTrue(name.length() > 0);
//        Assert.assertTrue(password.length() > 0);
    }
}