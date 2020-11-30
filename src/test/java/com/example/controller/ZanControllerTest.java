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
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ZanControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private CommentController commentController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void dozan() throws Exception{
        String uri = "/zan/dozan";

        JSONObject jsonObject1 = new  JSONObject();
        jsonObject1.put("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("did",669);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        Integer num = Integer.valueOf(str);
        Assert.assertTrue(num>0);
    }

    @Test
    void nozan() throws Exception{
        String uri = "/zan/nozan";


        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).param("id","5"))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        //  System.out.println(str);
        Assert.assertEquals("true",str);
    }

    @Test
    void iszan() throws Exception{
        String uri = "/zan/iszan";

        JSONObject jsonObject1 = new  JSONObject();
        jsonObject1.put("uid","oKWbe4iil3NhXw_Xx3V4itt8ACRQ");
        jsonObject1.put("did",700);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        Integer num = Integer.valueOf(str);
        Assert.assertTrue(num==-1);
    }
}