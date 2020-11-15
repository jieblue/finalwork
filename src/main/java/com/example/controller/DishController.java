package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.Service.ActionService;
import com.example.Service.NameService;
import com.example.entity.*;
import com.example.fileutil.FileSave;
import com.example.fileutil.GetMax;
import com.example.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class DishController {
    @Autowired
    NameService nameService;
    @Autowired
    ActionService actionService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    VcollectionMapper vcollectionMapper;
    @Autowired
    VcommentMapper vcommentMapper;
    @Autowired
    DishMapper dishMapper;
    @Autowired
    ActionMapper actionMapper;
    //返回菜品评论信息
    @RequestMapping(value = "/dish/getcomment", method = RequestMethod.POST)
    public List<Vcomment> getdishcomment(@RequestParam("did") Integer did) {
        VcommentExample example = new VcommentExample();
        VcommentExample.Criteria criteria = example.createCriteria();
        criteria.andDishidEqualTo(did);
        List<Vcomment> vcomments = vcommentMapper.selectByExample(example);
        return vcomments;
    }

    //返回菜品详细信息  小程序端
    @RequestMapping(value = "/dish/getinfo", method = RequestMethod.POST)
    public Dish getdishinfo(@RequestBody JSONObject jsonObject) {
        Integer did=jsonObject.getInteger("dishid");
        String uid=jsonObject.getString("uid");
        actionService.updateTypes(did,uid,1);
        Dish dish = dishMapper.selectByPrimaryKey(did);
        return dish;
    }
    //返回菜品详情 管理员端
    @RequestMapping(value = "/dish/getinfomation", method = RequestMethod.POST)
    public Dish getdishinfomation(@RequestParam("id") Integer id) {
        Dish dish = dishMapper.selectByPrimaryKey(id);
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
        String fname=nameService.getname();
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
   // 一次返回20菜品 由高到低
    @RequestMapping(value = "/dish/getdishes",method = RequestMethod.POST)
    public List<Dish> getdishes(@RequestParam("page") int page)
    {
        int size=20;
        DishExample example=new DishExample();
        example.setStartRow(page*size);
        example.setPageSize(size);
        DishExample.Criteria criteria=example.createCriteria();
        example.setOrderByClause("score desc");
        List<Dish> dishes=dishMapper.selectByExample(example);
        return dishes;
    }
    //返回全部菜品信息
    @RequestMapping(value = "/dish/getall",method = RequestMethod.GET)
    public List<Dish> getall()
    {
        DishExample example=new DishExample();
        DishExample.Criteria criteria=example.createCriteria();
        List<Dish> dishes=dishMapper.selectByExample(example);
        return dishes;
    }
    //每次返回10-28条推荐菜品
    @RequestMapping(value = "/dish/recommend",method = RequestMethod.POST)
    public List<Dish> getrecommend(@RequestBody JSONObject jsonObject)
    {
        String id=jsonObject.getString("id");
        int page=jsonObject.getInteger("page");
        Action action=actionMapper.selectByPrimaryKey(id);
        List<String> types= GetMax.findmax(action);
        String s0=types.get(0);
        String s1=types.get(1);
        String s2=types.get(2);
        DishExample example=new DishExample();
        DishExample.Criteria criteria=example.createCriteria();
        example.setPageSize(30);
        example.setStartRow(page*30);
        example.setOrderByClause("score desc");
        criteria.andFavorLike("%"+s0+"%");
        example.setDistinct(true);
        List<Dish> dishes=dishMapper.selectByExample(example);
        Collections.shuffle(dishes);

        dishes.subList(0,dishes.size()/2);
        ////////////////
        DishExample example1=new DishExample();
        DishExample.Criteria criteria1=example1.createCriteria();
        example1.setPageSize(12);
        example1.setOrderByClause("score desc");
        example1.setStartRow(page*12);
        criteria1.andFavorLike("%"+s1+"%")
                .andFavorNotLike("%"+s0+"%");

        example1.setDistinct(true);
        List<Dish> dishes1=dishMapper.selectByExample(example1);
        Collections.shuffle(dishes1);

        dishes1.subList(0,dishes1.size()/2);
        /////////////////////////////////
        DishExample example2=new DishExample();
        DishExample.Criteria criteria2=example2.createCriteria();
        example2.setPageSize(8);
        example2.setStartRow(page*8);
        example2.setOrderByClause("score desc");
        criteria2.andFavorLike("%"+s2+"%")
                .andFavorNotLike("%"+s0+"%")
                .andFavorNotLike("%"+s1+"%");
        example2.setDistinct(true);
        List<Dish> dishes2=dishMapper.selectByExample(example2);
        Collections.shuffle(dishes2);

        dishes2.subList(0,dishes2.size()/2);
        ///////////////////////////////////
        DishExample example3=new DishExample();
        DishExample.Criteria criteria3=example3.createCriteria();
        example3.setPageSize(6);
        example3.setStartRow(page*6);
        example3.setOrderByClause("score desc");

        criteria3.andFavorNotLike("%"+s1+"%");
        criteria3.andFavorNotLike("%"+s0+"%");
        criteria3.andFavorNotLike("%"+s2+"%");
        //example3.setDistinct(true);
        List<Dish> dishes3=dishMapper.selectByExample(example3);
        Collections.shuffle(dishes3);

        dishes3.subList(0,dishes3.size()/2);

        dishes.addAll(dishes1);
        dishes.addAll(dishes2);
        dishes.addAll(dishes3);
        Collections.shuffle(dishes);


        return dishes;

    }
    //////口味返回菜品
    @RequestMapping(value = "/dish/favor",method = RequestMethod.POST)
    public List<Dish> getfavordish(@RequestBody JSONObject jsonObject)
    {
        int page=jsonObject.getInteger("page");
        JSONArray jsonArray=jsonObject.getJSONArray("favor");
        List<String > types=new ArrayList<>();
        int len=jsonArray.size();
        for (int i=0;i<len;i++)
        {
            String tmp=jsonArray.getString(i);
            types.add(tmp);
        }
        DishExample example=new DishExample();
        DishExample.Criteria criteria=example.createCriteria();
        for (String type:types)
        {
            DishExample.Criteria criteria1=example.createCriteria();
            criteria1.andFavorLike("%"+type+"%");
            example.or(criteria1);
        }
        example.setPageSize(20);
        example.setStartRow(page*20);
        example.setDistinct(true);
        example.setOrderByClause("score desc");
        List<Dish> dishes=dishMapper.selectByExample(example);
        return dishes;
    }
    ////搜索api 每次返回20个
    @RequestMapping(value = "/dish/search",method = RequestMethod.POST)
    public List<Dish> getsearch(@RequestBody JSONObject jsonObject)
    {
        String word=jsonObject.getString("word");
        int page=jsonObject.getInteger("page");
        DishExample example=new DishExample();
        DishExample.Criteria criteria=example.createCriteria();
        criteria.andNameLike("%"+word+"%");
     //   example.or(criteria);
        DishExample.Criteria criteria1=example.createCriteria();
        criteria1.andRestaurantnameLike("%"+word+"%");
        example.or(criteria1);


        example.setDistinct(true);
        example.setPageSize(20);
        example.setStartRow(page*20);
        example.setOrderByClause("score desc");
        List<Dish> dishes=dishMapper.selectByExample(example);
        return dishes;
    }
}