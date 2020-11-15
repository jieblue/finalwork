package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Service.NameService;
import com.example.entity.*;
import com.example.fileutil.FileSave;
import com.example.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    NameService nameService;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    VcollectionMapper vcollectionMapper;
    @Autowired
    VcommentMapper vcommentMapper;
    @Autowired
    VcountMapper vcountMapper;
    @Autowired
    DishMapper dishMapper;
    //判断是否可以插入评论S
    @RequestMapping(value = "/comment/cancomment",method = RequestMethod.POST)
    public String cando(@RequestBody JSONObject jsonObject)
    {
        String uid=jsonObject.getString("uid");
        Integer did=jsonObject.getInteger("dishid");
        VcountExample example=new VcountExample();
        Date date=new Date();
        VcountExample.Criteria criteria=example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andTimeEqualTo(date);
        List<Vcount> vcounts= vcountMapper.selectByExample(example);
        User user=userMapper.selectByPrimaryKey(uid);
        if (user.getIntegral()<0)
            return "error1";//被拉黑
        CommentExample example1=new CommentExample();
        CommentExample.Criteria criteria1=example1.createCriteria();//判断是否评论过同一个菜品
        criteria1.andUidEqualTo(uid).andDishidEqualTo(did);
        List<Comment> comments=commentMapper.selectByExample(example1);
        if (!comments.isEmpty())
            return "error3";//禁止评论同一个菜品
        if (!vcounts.isEmpty())
        {
         //   Integer tmp=
            Vcount vcount=vcounts.get(0);
            if (vcount.getCount()>=user.getIntegral()/25+1)
                return "error2";//等级限制
        }

       return "true";
    }
    //插入评论
    @RequestMapping(value = "/comment/docomment",method = RequestMethod.POST)
    public String docomment(CInfo cInfo ) throws Exception {

        MultipartFile file=cInfo.getFile();
        String uid=cInfo.getUid();
        Integer did=cInfo.getDid();
        String text=cInfo.getText();
        float score=cInfo.getScore();
        //@RequestParam("picture")MultipartFile picture
        Date date1=new Date();

        String picname=nameService.getname()+uid+did.toString();
        String url="";
        if(file!=null)
        {
            url= FileSave.savefile(file,picname,0);
        }

        Comment comment=new Comment();
        comment.setCtime(date1);
        comment.setDishid(did);
        comment.setPic(url);
        comment.setText(text);
        comment.setUid(uid);
        comment.setScore(score);
        commentMapper.insert(comment);
        Dish dish=dishMapper.selectByPrimaryKey(did);
        float oldscore=dish.getScore();
        Integer oldnum=dish.getCommentnumber();
        float newscore=(oldscore*oldnum+score)/(oldnum+1);
        Integer newnum=oldnum+1;
        dish.setScore(newscore);
        dish.setCommentnumber(newnum);
        dishMapper.updateByPrimaryKey(dish);
        User user=userMapper.selectByPrimaryKey(uid);
        if (user.getIntegral()<=10000) {
            user.setIntegral(user.getIntegral() + 2);
            userMapper.updateByPrimaryKey(user);
        }
        return "true";
    }
    //删除评论
    @RequestMapping(value ="/comment/deletecomment",method = RequestMethod.POST)
    public String deletecomment(@RequestBody JSONObject jsonObject)
    {
        Dish dish=dishMapper.selectByPrimaryKey(jsonObject.getInteger("dishid"));
        String uid=jsonObject.getString("uid");
        User user=userMapper.selectByPrimaryKey(uid);
        user.setIntegral(user.getIntegral()-2);
        userMapper.updateByPrimaryKey(user);
        float dscore=jsonObject.getFloat("score");
        Integer oldnum=dish.getCommentnumber();
        float oldscore=dish.getScore();
        Integer newnum=oldnum-1;
        float newscore=(oldscore*oldnum-dscore)/newnum;
        dish.setScore(newscore);
        dish.setCommentnumber(newnum);
        dishMapper.updateByPrimaryKey(dish);
        commentMapper.deleteByPrimaryKey(jsonObject.getInteger("id"));
        return "true";
    }
}
