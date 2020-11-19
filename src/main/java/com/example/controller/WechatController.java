package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Service.NameService;
import com.example.Service.UserService;
import com.example.entity.UInfo;
import com.example.fileutil.FileSave;
import com.example.fileutil.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.Util.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class WechatController {
    @Autowired
    UserService userService;
    // 微信小程序ID
    @Value("${appid}")
    private String appid ;
    @Value("${appsecret}")
    private String secret;
    @Autowired
    NameService nameService;
    @RequestMapping(value = "/getOpenid",method = RequestMethod.POST)
    public String getOpenId(UInfo uInfo) throws Exception {
        String code=uInfo.getCode();
        String nickname=uInfo.getNickname();
        MultipartFile file=uInfo.getFile();
        String str;

    //    String fname=nameService.getname();
  //      String headurl= FileSave.saveuserfile(file,fname);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
             // 发送请求，返回Json字符串
        str = HttpUtil.doGet(url);
        JSONObject jsonObject=JSONObject.parseObject(str);
        String openid=jsonObject.getString("openid");
        userService.insertUser(openid,nickname,file);
//



        return openid;

    }


}
