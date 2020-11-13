package com.example.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
import com.example.fileutil.FileSave;
import com.example.mapper.*;
import org.apache.ibatis.annotations.Options;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class CommentController {
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
    //判断是否可以插入评论S
    @RequestMapping(value = "/user/cancomment",method = RequestMethod.POST)
    public String cando(@RequestParam("uid") String uid,@RequestParam("did") int did)
    {
        VcountExample example=new VcountExample();
        Date date=new Date();
        VcountExample.Criteria criteria=example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andTimeEqualTo(date);
        List<Vcount> vcounts= vcountMapper.selectByExample(example);
        User user=userMapper.selectByPrimaryKey(uid);
        if (user.getLevel()==0)
            return "false";
        if (!vcounts.isEmpty())
        {
            Vcount vcount=vcounts.get(0);
            if (vcount.getCount()>=user.getLevel())
                return "false";
        }
        CommentExample example1=new CommentExample();
        CommentExample.Criteria criteria1=example1.createCriteria();//判断是否评论过同一个菜品
        criteria1.andUidEqualTo(uid).andDishidEqualTo(did);
        List<Comment> comments=commentMapper.selectByExample(example1);
        if (!comments.isEmpty())
            return "false";
       return "true";
    }
    //插入评论
    @RequestMapping(value = "/user/docomment",method = RequestMethod.POST)
    public Comment docomment(CInfo cInfo ) throws Exception {

        MultipartFile file=cInfo.getFile();
        String uid=cInfo.getUid();
        Integer did=cInfo.getDid();
        String text=cInfo.getText();
        float score=cInfo.getScore();
        //@RequestParam("picture")MultipartFile picture
        Date date1=new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        System.out.println(formatter.format(date1).toString());
        String picname=uid+"and"+did.toString();
        String url= FileSave.savefile(file,picname);

        Comment comment=new Comment();
        comment.setCtime(date1);
        comment.setDishid(did);
        comment.setPic(url);
        comment.setText(text);
        comment.setUid(uid);
        comment.setScore(score);
        commentMapper.insert(comment);
        
        return comment;
    }

}
