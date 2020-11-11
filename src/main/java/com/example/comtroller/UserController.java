package com.example.comtroller;

import com.example.entity.*;
import com.example.mapper.UserMapper;
import com.example.mapper.VcollectionMapper;
import com.example.mapper.VcommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    VcollectionMapper vcollectionMapper;
    @Autowired
    VcommentMapper vcommentMapper;
    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    public List<User> getall()
    {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        List<User> R=userMapper.selectByExample(userExample);

        return R;
    }
    //返回用户收藏的菜品信息
    @RequestMapping(value = "/getcollection",method = RequestMethod.POST)
    public List<Vcollection> getcollection(@RequestParam("uid") String uid)
    {
        VcollectionExample example=new VcollectionExample();
        VcollectionExample.Criteria criteria=example.createCriteria();
        criteria.andUseridEqualTo(uid);
        List<Vcollection> vcollections=vcollectionMapper.selectByExample(example);
        return vcollections;
    }

    //返回菜品评论信息
    @RequestMapping(value = "/dish/getcomment",method = RequestMethod.POST)
    public List<Vcomment> getdishcomment(@RequestParam("did") Integer did)
    {
        VcommentExample example=new VcommentExample();
        VcommentExample.Criteria criteria=example.createCriteria();
        criteria.andDishidEqualTo(did);
        List<Vcomment> vcomments=vcommentMapper.selectByExample(example);
        return vcomments;
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
}
