package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Util.*;
@RestController
public class WechatController {
    @Autowired
    UserService userService;
    // 微信小程序ID
    String appid = "wxf58ee2afe27adfa8";
    // 微信小程序秘钥
    String secret = "1ec5fddade25c60a31574e9fb3d97c02";

    @RequestMapping("/getOpenId")
    public String getOpenId(@RequestBody JSONObject object) throws JsonProcessingException {
        String code=object.getString("code");
        String nickname=object.getString("nickname");
        try{
            // 根据小程序穿过来的code想这个url发送请求
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
            // 发送请求，返回Json字符串
            String str = WeChatUtil.httpRequest(url, "GET", null);
            JSONObject jsonObject=new JSONObject();
            jsonObject=JSONObject.parseObject(str);
            String openid=jsonObject.getString("openid");
            userService.insertUser(openid,nickname);
            return openid;
        }
        catch (Exception ex){
            return null;
        }
    }


}
