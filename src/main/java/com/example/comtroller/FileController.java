package com.example.comtroller;

import com.example.fileutil.FileSave;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FileController {
    @RequestMapping(value = "/fileupload",method = RequestMethod.POST)
    public  String saveFile(@RequestParam("file")MultipartFile file) throws Exception
    {
      //  System.out.println("fdsgszz");
        return FileSave.savefile(file,file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")));
    }
}
