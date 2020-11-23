package com.example.Service.impl;

import com.example.Service.ZanService;
import com.example.entity.Zan;
import com.example.entity.ZanExample;
import com.example.mapper.ZanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ZanService")
public class ZanServiceImpl  implements ZanService {
    @Autowired
    private ZanMapper zanMapper;
    @Override
    public Integer dozan(String uid, Integer did, int type) {
        if (type==0)
        {
            Zan zan=new Zan();
            zan.setDid(did);
            zan.setUid(uid);
            zanMapper.insert(zan);
            return zan.getId();
        }
        ZanExample zanExample=new ZanExample();
        ZanExample.Criteria criteria=zanExample.createCriteria();
        criteria.andDidEqualTo(did)
                .andUidEqualTo(uid);
        zanMapper.deleteByExample(zanExample);
        return 1;
    }

    @Override
    public int iszan(String uid, Integer did) {
        ZanExample zanExample=new ZanExample();
        ZanExample.Criteria criteria=zanExample.createCriteria();
        criteria.andDidEqualTo(did)
                .andUidEqualTo(uid);
        List<Zan> zans = zanMapper.selectByExample(zanExample);
        if (zans.isEmpty())
            return -1;
        return zans.get(0).getId();
    }

    @Async
    @Override
    public void nozan(Integer id) {
        zanMapper.deleteByPrimaryKey(id);
    }
}
