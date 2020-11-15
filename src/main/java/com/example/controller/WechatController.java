package com.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Util.*;
@RestController
public class WechatController {
    // 微信小程序ID
    String appid = "wxf58ee2afe27adfa8";
    // 微信小程序秘钥
    String secret = "1ec5fddade25c60a31574e9fb3d97c02";

    @RequestMapping("/getOpenId.do")
    public String getOpenId(String code) throws JsonProcessingException {
        try{
            // 根据小程序穿过来的code想这个url发送请求
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
            // 发送请求，返回Json字符串
            String str = WeChatUtil.httpRequest(url, "GET", null);
            return str;
        }
        catch (Exception ex){
            return null;
        }
    }

    @RequestMapping("/getUnionId.do")
    public String getUnionId(String encryptedData, String iv, String code)  {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        try{
            String str = WeChatUtil.httpRequest(url, "GET", null);
            String session_key=JacksonUtil.getFileValue(str,"session_key").toString();
            String result = AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            return result;
        }
        catch (Exception ex){
            return null;
        }
    }
}
