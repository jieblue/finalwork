package com.example.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
import com.example.mapper.ActionMapper;
import com.example.mapper.UserMapper;
import com.example.mapper.VcollectionMapper;
import com.example.mapper.VcommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    VcollectionMapper vcollectionMapper;
    @Autowired
    VcommentMapper vcommentMapper;
    @Autowired
    ActionMapper actionMapper;
//    @Autowired
//    UserMapper userMapper;
    //返回用户收藏的菜品信息
    @RequestMapping(value = "/user/getcollection",method = RequestMethod.POST)
    public List<Vcollection> getcollection(@RequestParam("uid") String uid)
    {
        VcollectionExample example=new VcollectionExample();
        VcollectionExample.Criteria criteria=example.createCriteria();
        criteria.andUseridEqualTo(uid);
        List<Vcollection> vcollections=vcollectionMapper.selectByExample(example);
        return vcollections;
    }


    //返回用户所有评论信息
    @RequestMapping(value = "/user/getcomment",method = RequestMethod.POST)
    public List<Vcomment> getusercomment(@RequestParam("uid") String uid)
    {
        VcommentExample example=new VcommentExample();
        VcommentExample.Criteria criteria=example.createCriteria();
        criteria.andUseridEqualTo(uid);
        List<Vcomment> vcomments=vcommentMapper.selectByExample(example);
        return vcomments;
    }
    //返回用户的等级
    @RequestMapping(value = "/user/integral",method = RequestMethod.POST)
    public int getlevel(@RequestParam("uid") String uid)
    {
        User user=userMapper.selectByPrimaryKey(uid);
        return user.getIntegral();
    }
    //插入用户
    @RequestMapping(value = "/user/insertuser",method = RequestMethod.POST)
    public String insertuser(@RequestBody JSONObject jsonObject)
    {
        String id=jsonObject.getString("id");
      //  Integer level=jsonObject.getInteger("level");
        String name=jsonObject.getString("name");
        User user=new User();
        user.setId(id);
        user.setName(name);
        userMapper.insert(user);
        Action action=new Action();
        action.setId(id);
        actionMapper.insert(action);
        return "true";
    }
    @RequestMapping(value = "/user/getusers",method = RequestMethod.GET)
    public List<User> getusers()
    {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        List<User> users=userMapper.selectByExample(example);
        return users;
    }
    @RequestMapping(value = "/user/setintegral")
    public String setintegral(@RequestBody JSONObject jsonObject)
    {
        String id=jsonObject.getString("id");
        Integer integral=jsonObject.getInteger("integral");
        if (integral>10000)
            integral=10000;
        else if (integral<-10000)
            integral=-10000;
        User user=userMapper.selectByPrimaryKey(id);
        user.setIntegral(integral);

        userMapper.updateByPrimaryKey(user);
        return "true";
    }
}
