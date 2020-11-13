package com.example.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Manager;
import com.example.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {
    @Autowired
    ManagerMapper managerMapper;

    @RequestMapping(value = "/manager/login",method = RequestMethod.POST)
    public String login(@RequestBody JSONObject jsonObject)
    {
        String laccount=jsonObject.getString("account");
        String lpassword=jsonObject.getString("password");
        Manager manager=managerMapper.selectByPrimaryKey(laccount);
        if (manager==null)
            return "false";
        if (!manager.getPassword().equals(lpassword))
            return "false";
        return "true";
    }
}
