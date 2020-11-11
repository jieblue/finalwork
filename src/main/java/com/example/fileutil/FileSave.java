package com.example.fileutil;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileSave {
    public static String  savefile(MultipartFile file,String sname) throws Exception
    {
        String staticpath= ResourceUtils.getURL("static").getPath();
        String name=file.getOriginalFilename();
        // String staticpath1=ResourceUtils.getURL("classpath:").getPath()+"static/images";


        //String sname = name.substring(0,name.lastIndexOf(".") );
        sname=sname+".jpg";
        String savepath=staticpath+"\\commentpic\\"+sname;
        try {
            // 先尝试压缩并保存图片
            Thumbnails.of(file.getInputStream())
                    .size(600,400)
                    .outputQuality(1f)
                    .outputFormat("jpg")
                    .toFile(savepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return "150.158.153.134:8080/static/commentpic/"+sname;
    }
}
