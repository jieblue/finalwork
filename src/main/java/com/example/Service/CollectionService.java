package com.example.Service;

import com.example.entity.Collection;
import com.example.entity.CollectionExample;
import com.example.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    public boolean isCollected(String uid,Integer did)
    {
        CollectionExample example=new CollectionExample();
        CollectionExample.Criteria criteria=example.createCriteria();
        criteria.andDishidEqualTo(did)
                .andUidEqualTo(uid);
        List<Collection> collections = collectionMapper.selectByExample(example);
        if (!collections.isEmpty())
            return true;
        return false;
    }
}
