package com.example.Service;

import com.example.entity.Action;
import com.example.entity.User;
import com.example.mapper.ActionMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ActionMapper actionMapper;
    public void insertUser(String uid,String name)
    {
        User user=userMapper.selectByPrimaryKey(uid);
        User user1=new User();
        user1.setId(uid);
        user1.setName(name);
        if (user==null)
        {
            userMapper.insert(user1);
            Action action=new Action();
            action.setId(uid);
            actionMapper.insert(action);
        }
        else
        {
            userMapper.updateByPrimaryKey(user);
        }

    }
}
