package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Service.VzanService;
import com.example.entity.Vzan;
import com.example.mapper.VzanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VzanController {
    @Autowired
    VzanService vzanService;
    @RequestMapping(value = "/zan/zans",method = RequestMethod.POST)
    public List<Vzan> iszan(@RequestParam("id") String id)
    {
       return vzanService.getzan(id);
    }
}
