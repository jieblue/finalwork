package com.example.Service.impl;

import com.example.entity.Vzan;
import com.example.entity.VzanExample;
import com.example.entity.Zan;
import com.example.mapper.VzanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("VzanService")
public class VzanServiceImpl implements com.example.Service.VzanService {
    @Autowired
    VzanMapper vzanMapper;
    @Override
    public List<Vzan> getzan(String uid) {
        VzanExample example=new VzanExample();
        VzanExample.Criteria criteria=example.createCriteria();
        criteria.andUidEqualTo(uid);
        List<Vzan> vzans=vzanMapper.selectByExample(example);
        return vzans;
    }
}
