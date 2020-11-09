package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.User;
import com.example.entity.UserExample;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    public List<User> getall()
    {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        List<User> R=userMapper.selectByExample(userExample);

        return R;
    }
}
