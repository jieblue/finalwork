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
        User user=new User();
        user.setName(name);
        user.setId(uid);
        Action action=new Action();
        action.setId(uid);
        userMapper.insert(user);
        actionMapper.insert(action);
    }
}
