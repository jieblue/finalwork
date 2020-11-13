package com.example.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
import com.example.fileutil.FileSave;
import com.example.mapper.DishMapper;
import com.example.mapper.UserMapper;
import com.example.mapper.VcollectionMapper;
import com.example.mapper.VcommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    @RequestMapping(value = "/dish/getcomment", method = RequestMethod.POST)
    public List<Vcomment> getdishcomment(@RequestParam("did") Integer did) {
        VcommentExample example = new VcommentExample();
        VcommentExample.Criteria criteria = example.createCriteria();
        criteria.andDishidEqualTo(did);
        List<Vcomment> vcomments = vcommentMapper.selectByExample(example);
        return vcomments;
    }

    //返回菜品详细信息
    @RequestMapping(value = "/dish/getinfo", method = RequestMethod.POST)
    public Dish getdishinfo(@RequestParam("did") Integer did) {
        Dish dish = dishMapper.selectByPrimaryKey(did);
        return dish;
    }

    //插入菜品
    @RequestMapping(value = "/dish/insertdish", method = RequestMethod.POST)
    public String insertdish(DInfo dInfo) throws Exception {
        DishExample example = new DishExample();
        DishExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(dInfo.getName())
                .andRestaurantlocationEqualTo(dInfo.getRlocation())
                .andRestaurantnameEqualTo(dInfo.getRname());
        List<Dish> dishes = dishMapper.selectByExample(example);
        if (!dishes.isEmpty())
            return "exist";
        Date date = new Date();
        String strDateFormat = "yyyy-MM-ddHH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String origin=sdf.format(date);
        String[] tmp=origin.split("-|:");
        String fname ="";
        for (String i:tmp)
            fname=fname+i;

        String url = FileSave.savefile(dInfo.getFile(), fname, 1);
        Dish dish = new Dish();
        dish.setCategory(dInfo.getCategory());
        dish.setRestaurantlocation(dInfo.getRlocation());
        dish.setFavor(dInfo.getFavor());
        dish.setRestaurantname(dInfo.getRname());
        dish.setName(dInfo.getName());
        dish.setPrice(dInfo.getPrice());
        dish.setPicurl(url);
        dishMapper.insert(dish);
        return "true";
    }

    //修改菜品信息 不包括图片
    @RequestMapping(value = "/dish/updatedish", method = RequestMethod.POST)
    public String updatedish(@RequestBody JSONObject jsonObject) throws Exception {
        Integer id = jsonObject.getInteger("id");
        String name = jsonObject.getString("name");
        String favor = jsonObject.getString("favor");
        String category = jsonObject.getString("category");
        String rname = jsonObject.getString("rname");
        String rlocation = jsonObject.getString("rlocation");
        float price = jsonObject.getFloat("price");
        float score = jsonObject.getFloat("score");
        Integer num = jsonObject.getInteger("num");
        String url = jsonObject.getString("url");
        Dish dish = new Dish();
        dish.setPicurl(url);
        dish.setCommentnumber(num);
        dish.setScore(score);
        dish.setPrice(price);
        dish.setRestaurantlocation(rlocation);
        dish.setRestaurantname(rname);
        dish.setCategory(category);
        dish.setFavor(favor);
        dish.setName(name);
        dish.setId(id);
        dishMapper.updateByPrimaryKey(dish);
        return "true";
    }
    //修改菜品图片
    @RequestMapping(value = "/dish/updatedishpic" ,method = RequestMethod.POST)
    public String updatedishpic(UDInfo udInfo)throws Exception
    {
        String old=udInfo.getUrl();
        String name=old.substring(old.lastIndexOf("/")+1,old.lastIndexOf("."));
        FileSave.savefile(udInfo.getFile(),name,1);
        return "true";
    }
    //删除菜品
    @RequestMapping(value = "/dish/deletedish" ,method = RequestMethod.POST)
    public String deletedish(@RequestParam("id") Integer id)throws Exception
    {
        dishMapper.deleteByPrimaryKey(id);
        return "true";
    }
}