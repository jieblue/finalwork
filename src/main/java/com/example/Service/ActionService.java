package com.example.Service;


import com.example.entity.Action;
import com.example.entity.Dish;
import com.example.mapper.ActionMapper;
import com.example.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private DishMapper dishMapper;

    public  void updateTypes(Integer did,String uid,int delta){
        Action action=actionMapper.selectByPrimaryKey(uid);
        Dish dish =dishMapper.selectByPrimaryKey(did);
        String favor=dish.getFavor();
        if (dish.getFavor()==null)
            return;
        String[] types=favor.split(",");
        for (String tmp:types)
        {
            //System.out.println(tmp);
            if (tmp.equals("酸"))
            {
                action.setType1(action.getType1()+delta);
            }
            else if (tmp.equals("甜"))
            {
                action.setType2(action.getType2()+delta);
            }
            else if (tmp.equals("苦"))
            {
                action.setType3(action.getType3()+delta);
            }
            else if (tmp.equals("辣"))
            {
                action.setType4(action.getType4()+delta);
            }
            else if (tmp.equals("咸"))
            {
                action.setType5(action.getType5()+delta);
            }
            else if (tmp.equals("清淡"))
            {
                action.setType6(action.getType6()+delta);
            }
            else if(tmp.equals("重口味"))
            {
                action.setType7(action.getType7()+delta);
              //  System.out.println(action.getType7());
            }
        }
        actionMapper.updateByPrimaryKey(action);
    }
}
