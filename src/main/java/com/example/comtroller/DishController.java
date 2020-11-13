package com.example.comtroller;

import com.example.entity.Dish;
import com.example.entity.Vcomment;
import com.example.entity.VcommentExample;
import com.example.mapper.DishMapper;
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
public class DishController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    VcollectionMapper vcollectionMapper;
    @Autowired
    VcommentMapper vcommentMapper;
    @Autowired
    DishMapper dishMapper;
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
    //返回菜品详细信息
    @RequestMapping(value = "/dish/getinfo",method = RequestMethod.POST)
    public Dish getdishinfo(@RequestParam("did") Integer did)
    {
        Dish dish=dishMapper.selectByPrimaryKey(did);
        return dish;
    }
}
