package com.example.Service;

import com.example.entity.Action;
import com.example.entity.User;
import com.example.fileutil.FileSave;
import com.example.mapper.ActionMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ActionMapper actionMapper;
    @Autowired
    NameService nameService;
    public void insertUser(String uid, String name, String url) throws Exception
    {
        User user=userMapper.selectByPrimaryKey(uid);
        User user1=new User();
        user1.setId(uid);


        user1.setName(name);
        if (user==null)
        {
            user1.setIntegral(25);
            user1.setUrl(url);
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
            String oldname=user.getUrl();
            user1.setUrl(oldname);
            user1.setIntegral(user.getIntegral());
            userMapper.updateByPrimaryKey(user1);
        }

    }
}
