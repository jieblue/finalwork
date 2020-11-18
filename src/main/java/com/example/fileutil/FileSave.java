package com.example.fileutil;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileSave {
    public static String  savefile(MultipartFile file,String sname,int op) throws Exception
    {
        String staticpath= ResourceUtils.getURL("static").getPath();
        String name=file.getOriginalFilename();
        // String staticpath1=ResourceUtils.getURL("classpath:").getPath()+"static/images";


        //String sname = name.substring(0,name.lastIndexOf(".") );
        sname=sname+".jpeg";
        String tname="";
        if (op==0)
            tname="comment";
        else if (op==1)
            tname="heads";
        String savepath=staticpath+"\\"+tname+"\\"+sname;
        try {
            // 先尝试压缩并保存图片
            Thumbnails.of(file.getInputStream())
                    .size(600,400)
                    .outputQuality(0.45f)
                    .outputFormat("jpeg")
                    .toFile(savepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return "https://www.jieblue.xyz:8080/static/"+tname+"/"+sname;
    }
    public static String  savesmallfile(MultipartFile file,String sname,int op) throws Exception
    {
        String staticpath= ResourceUtils.getURL("static").getPath();
        String name=file.getOriginalFilename();
        // String staticpath1=ResourceUtils.getURL("classpath:").getPath()+"static/images";


        //String sname = name.substring(0,name.lastIndexOf(".") );
        sname=sname+".jpeg";
        String tname="";
        if (op==0)
            tname="smallcomment";
        else if (op==1)
            tname="smallheads";
        String savepath=staticpath+"\\"+tname+"\\"+sname;
        try {
            // 先尝试压缩并保存图片
            Thumbnails.of(file.getInputStream())
                    .size(600,400)
                    .outputQuality(0.16f)
                    .outputFormat("jpeg")
                    .toFile(savepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return "https://www.jieblue.xyz:8080/static/"+tname+"/"+sname;
    }
    public static String savecommentfile(MultipartFile file,String name) throws Exception
    {
        String staticpath=ResourceUtils.getURL("static").getPath();
        name=name+".jpeg";
        String savepath=staticpath+"\\comment\\"+name;
        File savefile=new File(savepath);
        if (!savefile.exists())
            savefile.mkdirs();
        file.transferTo(savefile);
        return "https://www.jieblue.xyz:8080/static/comment/"+name;
    }
    public static String saveuserfile(MultipartFile file,String name) throws Exception
    {
        String staticpath=ResourceUtils.getURL("static").getPath();
        name=name+".jpeg";
        String savepath=staticpath+"\\user\\"+name;
        File savefile=new File(savepath);
        if (!savefile.exists())
            savefile.mkdirs();
        file.transferTo(savefile);
        return "https://www.jieblue.xyz:8080/static/user/"+name;
    }
}
