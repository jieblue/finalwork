package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.service.*;
import com.example.entity.User;
import com.example.entity.Vzan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DemoApplicationTests {
//    @Autowired
//    private HtmlController htmlController;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ActionService actionService;
    @Autowired
    private VzanService vzanService;
    @Autowired
    private UserService userService;
    @Autowired
    private ZanService zanService;
    @Autowired
    NameService nameService;
    @Autowired
    CollectionService collectionService;
    private MockMvc mockMvc;
    @Before
    public void setup()
    {
        this.mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void USTest()
    {
        User user = new User();
        user.setId("oKWbe4iil3NhXw_Xx3V4itt8ACRQ");
        user.setName("jie");
        try {
            userService.insertUser(user.getId(),user.getName(),user.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void ZSTest()
    {
        int res1 = zanService.iszan("oKWbe4iil3NhXw_Xx3V4itt8ACRQ",776);
        Assert.assertEquals(5,res1);
        int res2 = zanService.dozan("oKWbe4iil3NhXw_Xx3V4itt8ACRQ",779,0);
        Assert.assertTrue(res2>0);
    }
    @Test
    public void CSTest()
    {
        int res1 = collectionService.isCollected("oKWbe4iil3NhXw_Xx3V4itt8ACRQ",546);
        Assert.assertTrue(res1>0);
    }
    @Test
    public void NSTest()
    {
        String res1 = nameService.getname();
        Assert.assertTrue(res1.length()>10);
    }
    @Test
    public void VZSTest()
    {
        List<Vzan> res = vzanService.getzan("oKWbe4iil3NhXw_Xx3V4itt8ACRQ");
        Assert.assertNotNull(res);
    }
    @Test
    public void ASTest()
    {
        Integer did = 556;
        String uid = "oKWbe4iil3NhXw_Xx3V4itt8ACRQ";
        Integer delta = 1;
        try {
            actionService.updateTypes(did,uid,delta);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
//    @Test
//    public void getcountresult() throws Exception{
//
//        String uri = "/comment/cancomment";
//        JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("uid","oKWbe4jdj04FjNavU3hZ8Hf5DBMs");
//        jsonObject1.put("dishid",556);
//
//
//        MvcResult mvcResult = this.mockMvc
//                .perform(MockMvcRequestBuilders.post(uri))
//                .andReturn();// 获取返回结果
//
//        // 打印返回结果
//        System.out.println(mvcResult.getResponse().getContentAsString());
//    }
}
