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
    public void insertUser(String uid,String name,String url)
    {
        User user=userMapper.selectByPrimaryKey(uid);
        User user1=new User();
        user1.setId(uid);
        user1.setUrl(url);
        user1.setName(name);
        if (user==null)
        {
            user1.setIntegral(25);

            userMapper.insert(user1);
            Action action=new Action();
            action.setId(uid);
            action.setType1(0);
            action.setType2(0);
            action.setType3(0);
            action.setType4(0);
            action.setType5(0);
            action.setType6(0);
            action.setType7(0);
            actionMapper.insert(action);
        }
        else
        {
            user1.setIntegral(user.getIntegral());
            userMapper.updateByPrimaryKey(user1);
        }

    }
}
