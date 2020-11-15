package com.example.Util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(Include.NON_EMPTY);
    }

    //json转bean
    public static <T> T deserialize(String json,Class<T> cls){
        T t = null;
        try{
            t=mapper.readValue(json, cls);
        }catch (Exception ex){
            return null;
        }
        return t;
    }

    public static Object getFileValue(String json,String filedName) {
        try{
            JsonNode rootNode = mapper.readTree(json);
            return rootNode.get(filedName);
        }
        catch (Exception ex){
            return "";
        }
    }

    //json数组转bean
    public static <T> List<T> decode(String json,Class<T> cls) {
        List<T> list;
        try{
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, cls);
            list=(List<T>)mapper.readValue(json, javaType);
        }
        catch (Exception ex){
            return null;
        }
        return list;
    }

    //bean转json
    public static String beanToJson(Object obj) {
        String json="";
        try {
            json=mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }

    //list转json
    public static String listToJson(List list){
        String json="";
        try {
            json=mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }
}