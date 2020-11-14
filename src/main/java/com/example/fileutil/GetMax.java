package com.example.fileutil;

import com.example.entity.Action;

import java.util.ArrayList;
import java.util.List;

public class GetMax {
    public static List<String> findmax(Action action)
    {
        List<String> types=new ArrayList<>();
        String[] origin=new String[]{"酸","甜","苦","辣","咸","清淡","重口味"};
        List<Integer> num=new ArrayList<Integer>();
        num.add(action.getType1());
        num.add(action.getType2());
        num.add(action.getType3());
        num.add(action.getType4());
        num.add(action.getType5());
        num.add(action.getType6());
        num.add(action.getType7());
        //System.out.println(num);
        for (int i=0;i<3;i++)
        {
            int max=0;

            String type="";
           // System.out.println(max+" "+type);
            for (int j=0;j<7;j++)
            {
                if (num.get(j)>=max)
                {
                    String op=origin[j];
                    if (!types.contains(op))
                    {
                        //System.out.println(op);
                        type=op;
                        max=num.get(j);
                    }
                }
            }
           // System.out.println(max+"    "+type);
            types.add(type);
        }
        return types;
    }
}
