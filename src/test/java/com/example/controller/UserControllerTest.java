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
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private CommentController commentController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;
    @Test
    void getcollection() throws Exception {
        String uri = "/user/getcollection";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(str);
        //  System.out.println(str);
        Assert.assertNotNull(jsonArray);

    }
    @Test
    void getusercomment() throws  Exception{
            String uri = "/user/getcomment";

            MvcResult mvcResult = this.mockMvc
                    .perform(MockMvcRequestBuilders.post(uri).param("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs"))
                    .andReturn();// 获取返回结果

            // 打印返回结果
            String str = mvcResult.getResponse().getContentAsString();
            JSONArray jsonArray = JSONArray.parseArray(str);
            //  System.out.println(str);
            Assert.assertNotNull(jsonArray);


    }

    @Test
    void getlevel() throws Exception{
        String uri = "/user/integral";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        Integer num = Integer.valueOf(str);
        Assert.assertTrue(num>20);
    }

    @Test
    void getusers() throws Exception{
        String uri = "/user/getusers";

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
    void setintegral() throws Exception{
        String uri = "/user/setintegral";

            JSONObject jsonObject1 = new  JSONObject();
        jsonObject1.put("id","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("integral",1000000);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("true",str);
    }

    @Test
    void addcollection() throws Exception{
        String uri = "/user/addcollection";

        JSONObject jsonObject1 = new  JSONObject();
        jsonObject1.put("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("dishid",557);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        Integer num = Integer.valueOf(str);
        Assert.assertTrue(num>0);
    }

    @Test
    void deletecollection() throws Exception{
        String uri = "/user/deletecollection";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("id","39"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        //  System.out.println(str);
        Assert.assertEquals("true",str);
    }

    @Test
    void iscollection() throws Exception{
        String uri = "/user/iscollected";

        JSONObject jsonObject1 = new  JSONObject();
        jsonObject1.put("uid","oKWbe4iil3NhXw_Xx3V4itt8ACRQ");
        jsonObject1.put("dishid",548);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        Integer num = Integer.valueOf(str);
        Assert.assertTrue(num>0);
    }
}