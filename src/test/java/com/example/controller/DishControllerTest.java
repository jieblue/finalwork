package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.entity.Dish;
import com.example.mapper.DishMapper;
import org.junit.jupiter.api.BeforeEach;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DishControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private CommentController commentController;
    @Autowired
    DishMapper dishMapper;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;
    @Test
    void getdishcomment() throws Exception{
        String uri = "/dish/getcomment";


        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("did","556"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        //  System.out.println(str);

        JSONArray jsonArray = JSONArray.parseArray(str);
        //  System.out.println(str);
        Assert.assertNotNull(jsonArray);
    }

    @Test
    void getdishinfo() throws Exception{
        String uri = "/dish/getinfo";
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("dishid",556);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONObject jsonObject = JSONObject.parseObject(str);
        Integer id = 556;
        //  System.out.println(str);
        Assert.assertEquals(id,jsonObject.getInteger("id"));

    }

    @Test
    void getdishinfomation() throws Exception{
        String uri = "/dish/getinfomation";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("id","556"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONObject jsonObject = JSONObject.parseObject(str);
        Integer id = 556;
        //  System.out.println(str);
        Assert.assertEquals(id,jsonObject.getInteger("id"));
    }

    @Test
    void insertdish() {
    }

    @Test
    void updatedish() throws  Exception{
        String uri = "/dish/updatedish";
        Dish dish = dishMapper.selectByPrimaryKey(556);
        String jstr = JSONObject.toJSONString(dish);
        JSONObject jsonObject= JSONObject.parseObject(jstr);
//            JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("id","556");
//        jsonObject1.put("score",3.5);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("true",str);

    }

    @Test
    void updatedishpic() {
    }

    @Test
    void deletedish() throws Exception{
        String uri = "/dish/deletedish";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("id","556"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        //  System.out.println(str);
        Assert.assertEquals("true",str);
    }

    @Test
    void getdishes() throws Exception{
        String uri = "/dish/getdishes";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("page","0"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(str);
        //  System.out.println(str);
        Assert.assertNotNull(jsonArray);
    }

    @Test
    void getall() throws Exception{
        String uri = "/dish/getall";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get(uri))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(str);
        //  System.out.println(str);
        Assert.assertNotNull(jsonArray);
    }

    @Test
    void getrecommend() throws Exception{
        String uri = "/dish/recommend";
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("page",0);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(str);
        //  System.out.println(str);
        Assert.assertNotNull(jsonArray);
    }

    @Test
    void getfavordish() throws Exception{
        String uri = "/dish/favor";
        JSONObject jsonObject1 = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("咸");
        jsonObject1.put("favor",list);
        jsonObject1.put("page",0);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(str);
        //  System.out.println(str);
        Assert.assertNotNull(jsonArray);
    }

    @Test
    void getsearch() throws Exception{
        String uri = "/dish/search";
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("word","宫保鸡丁");
        jsonObject1.put("page",0);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(str);
       //  System.out.println(str);
        Assert.assertNotNull(jsonArray);
    }
}