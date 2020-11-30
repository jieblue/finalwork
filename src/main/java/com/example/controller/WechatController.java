package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.NameService;
import com.example.service.UserService;
import com.example.fileutil.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String getOpenId(@RequestBody JSONObject jsonObject) throws Exception {
        String code=jsonObject.getString("code");
        String nickname=jsonObject.getString("nickname");
        String aurl=jsonObject.getString("url");
        String str;

    //    String fname=nameService.getname();
  //      String headurl= FileSave.saveuserfile(file,fname);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
             // 发送请求，返回Json字符串
        str = HttpUtil.doGet(url);
        JSONObject jsonObject1=JSONObject.parseObject(str);
        String openid=jsonObject1.getString("openid");
        userService.insertUser(openid,nickname,aurl);
        return openid;

    }


}
