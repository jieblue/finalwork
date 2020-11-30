package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ZanController {
    @Autowired
    ZanService zanService;

    @RequestMapping(value = "/zan/dozan",method = RequestMethod.POST)
    public Integer dozan(@RequestBody JSONObject jsonObject)
    {
        String uid=jsonObject.getString("uid");
        Integer did=jsonObject.getInteger("did");
        return zanService.dozan(uid,did,0);
    }
    @RequestMapping(value = "/zan/nozan",method = RequestMethod.POST)
    public String nozan(@RequestParam("id") int id)
    {
        zanService.nozan(id);
        return "true";
    }
    @RequestMapping(value = "/zan/iszan",method = RequestMethod.POST)
    public int iszan(@RequestBody JSONObject jsonObject)
    {
        String uid=jsonObject.getString("uid");
        Integer did=jsonObject.getInteger("did");
        return zanService.iszan(uid,did);

    }
}
