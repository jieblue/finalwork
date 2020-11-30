package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
class CommentControllerTest {

    @Autowired
    private UserController userController;
    @Autowired
    private CommentController commentController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void cando() throws Exception{
        String uri = "/comment/cancomment";
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("dishid",666);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
       // System.out.println(str);
        Assert.assertEquals("true",str);
    }

    @Test
    void docomment() {
    }

    @Test
    void deletecomment() throws Exception{
        String uri = "/comment/deletecomment";
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("dishid",556);
        jsonObject1.put("score",1);
        jsonObject1.put("id",135);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).content(jsonObject1.toString()).contentType(MediaType.APPLICATION_JSON))
                .andReturn();// 获取返回结果

        // 打印返回结果
        String str = mvcResult.getResponse().getContentAsString();
        // System.out.println(str);
        Assert.assertEquals("true",str);
    }
}