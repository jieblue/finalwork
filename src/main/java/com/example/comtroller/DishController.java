package com.example.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
import com.example.fileutil.FileSave;
import com.example.fileutil.GetMax;
import com.example.mapper.*;
import javafx.scene.chart.ValueAxis;
import com.github.pagehelper.PageHelper;
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
        String favor=jsonObject.getString("favor");
        String[] types=favor.split(",");
        Action action=actionMapper.selectByPrimaryKey(uid);
        for (String tmp:types)
        {
            if (tmp.equals("酸"))
            {
                action.setType1(action.getType1()+1);
            }
            else if (tmp.equals("甜"))
            {
                action.setType2(action.getType2()+1);
            }
            else if (tmp.equals("苦"))
            {
                action.setType3(action.getType3()+1);
            }
            else if (tmp.equals("辣"))
            {
                action.setType4(action.getType4()+1);
            }
            else if (tmp.equals("咸"))
            {
                action.setType5(action.getType5()+1);
            }
            else if (tmp.equals("清淡"))
            {
                action.setType6(action.getType6()+1);
            }
            else if(tmp.equals("重口味"))
            {
                action.setType7(action.getType7()+1);
            }
        }
        actionMapper.updateByPrimaryKey(action);
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
   // 一次返回20菜品 由高到低
    @RequestMapping(value = "/dish/getdishes",method = RequestMethod.POST)
    public List<Dish> getdishes(@RequestParam("page") int page)
    {
        DishExample example=new DishExample();
        example.setStartRow(page);
        example.setPageSize(5);
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
        example.setPageSize(10);
        example.setStartRow(page);
        example.setOrderByClause("score desc");
        criteria.andFavorLike("%"+s0+"%");
        example.setDistinct(true);
        List<Dish> dishes=dishMapper.selectByExample(example);
        ////////////////
        DishExample example1=new DishExample();
        DishExample.Criteria criteria1=example1.createCriteria();
        example1.setPageSize(4);
        example1.setOrderByClause("score desc");
        example1.setStartRow(page);
        criteria1.andFavorLike("%"+s1+"%");

        example1.setDistinct(true);
        List<Dish> dishes1=dishMapper.selectByExample(example1);
        /////////////////////////////////
        DishExample example2=new DishExample();
        DishExample.Criteria criteria2=example2.createCriteria();
        example2.setPageSize(4);
        example2.setStartRow(page);
        example2.setOrderByClause("score desc");
        criteria2.andFavorLike("%"+s2+"%")
                .andFavorNotLike("%"+s0+"%")
                .andFavorNotLike("%"+s1+"%");
        example2.setDistinct(true);
        List<Dish> dishes2=dishMapper.selectByExample(example2);
        ///////////////////////////////////
        DishExample example3=new DishExample();
        DishExample.Criteria criteria3=example3.createCriteria();
        example3.setPageSize(10);
        example3.setStartRow(page);
        example3.setOrderByClause("score desc");

        criteria3.andFavorNotLike("%"+s1+"%");
        criteria3.andFavorNotLike("%"+s0+"%");
        criteria3.andFavorNotLike("%"+s2+"%");
        //example3.setDistinct(true);
        List<Dish> dishes3=dishMapper.selectByExample(example3);


        dishes.addAll(dishes1);
        dishes.addAll(dishes2);
        dishes.addAll(dishes3);
        return dishes;

    }
}