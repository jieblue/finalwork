package com.example.Service;

import org.springframework.stereotype.Service;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class NameService {
    public String getname()
    {

        String uuidFileName=UUID.randomUUID().toString().replace("-","");
        Date date = new Date();
        String strDateFormat = "yyyy-MM-ddHH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String origin=sdf.format(date);
        String[] tmp=origin.split("-|:");
        String fname ="";
        for (String i:tmp)
            fname=fname+i;
        return uuidFileName+fname;
    }
}
