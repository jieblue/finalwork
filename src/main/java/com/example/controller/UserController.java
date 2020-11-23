package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Service.ActionService;
import com.example.Service.CollectionService;
import com.example.entity.*;
import com.example.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    CollectionService collectionService;
    @Autowired
    ActionService actionService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    VcollectionMapper vcollectionMapper;
    @Autowired
    VcommentMapper vcommentMapper;
    @Autowired
    ActionMapper actionMapper;
    @Autowired
    DishMapper dishMapper;
    @Autowired
    CollectionMapper collectionMapper;
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
    //返回所有用户信息
    @RequestMapping(value = "/user/getusers",method = RequestMethod.GET)
    public List<User> getusers()
    {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        List<User> users=userMapper.selectByExample(example);
        return users;
    }
    //更改用户的积分
    @RequestMapping(value = "/user/setintegral")
    public String setintegral(@RequestBody JSONObject jsonObject)
    {
        String id=jsonObject.getString("id");
        Integer integral=jsonObject.getInteger("integral");
        if (integral>10000)//zuida 10000
            integral=10000;
        else if (integral<-10000)
            integral=-10000;
        User user=userMapper.selectByPrimaryKey(id);
        user.setIntegral(integral);

        userMapper.updateByPrimaryKey(user);
        return "true";
    }
    //添加收藏
    @RequestMapping(value = "/user/addcollection",method = RequestMethod.POST)
    public Integer addcollection(@RequestBody JSONObject jsonObject)
    {
        String uid=jsonObject.getString("uid");
        Integer did=jsonObject.getInteger("dishid");
        actionService.updateTypes(did,uid,3);
        if (collectionService.isCollected(uid,did))
            return -1;
        Collection collection=new Collection();
        collection.setDishid(did);
        collection.setUid(uid);
        collectionMapper.insert(collection);
        return collection.getId();
    }
    //取消收藏
    @RequestMapping(value = "/user/deletecollection",method = RequestMethod.POST)
    public String deletecollection(@RequestParam("id") Integer id)
    {
        Collection collection=collectionMapper.selectByPrimaryKey(id);
        Integer did=collection.getDishid();
        String uid =collection.getUid();
        actionService.updateTypes(did,uid,-5);
        collectionMapper.deleteByPrimaryKey(id);
        return "true";
    }
    //返回是否收藏
    @RequestMapping(value = "/user/iscollected",method = RequestMethod.POST)
    public boolean iscollection(@RequestBody JSONObject jsonObject)
    {

        Integer did=jsonObject.getInteger("dishid");
        String uid=jsonObject.getString("uid");
        if (collectionService.isCollected(uid,did))
            return true;
        return false;
    }
}
