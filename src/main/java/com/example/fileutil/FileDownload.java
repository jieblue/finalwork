package com.example.fileutil;

import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

public class FileDownload {
    public static void download(String name, HttpServletResponse response) throws Exception {
        String staticpath= ResourceUtils.getURL("static").getPath();
        String path=staticpath+"\\heads\\";
        File file = new File(path+ name);

        FileInputStream fileInputStream=new FileInputStream(file);
        OutputStream outputStream=response.getOutputStream();
        byte[] buff=new byte[1024];

        BufferedInputStream inputStream=null;
        inputStream=new BufferedInputStream(fileInputStream);
        int i= inputStream.read(buff);
        while (i!=-1)
        {
            outputStream.write(buff,0,i);
            outputStream.flush();
            i=inputStream.read(buff);
        }

    }
}
