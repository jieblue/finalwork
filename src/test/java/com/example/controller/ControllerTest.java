package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.*;
import com.example.entity.User;
import com.example.entity.Vzan;
import org.junit.Assert;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
//    @Autowired
//    private HtmlController htmlController;

    @Autowired
    private UserController userController;
    @Autowired
    private CommentController commentController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

//    @Before
//    public void setup()
//    {
//        this.mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }

    @Test
    public void commentTest() throws Exception{

        String uri = "/comment/cancomment";
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
        jsonObject1.put("dishid",556);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(jsonObject1.toString()))
                .andReturn();// 获取返回结果

        // 打印返回结果
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void userTest() throws Exception{

        String uri = "/user/getusers";

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get(uri))
                .andReturn();// 获取返回结果

        // 打印返回结果
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
