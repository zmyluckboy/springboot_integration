package com.hwsoft.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

public class JsonUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String obj2Strong(T obj){
        if (obj == null){
            return  null;
        }
        try {
            return obj instanceof  String ? (String) obj : objectMapper.writeValueAsString(obj);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T string2Obj(String str, Class<T> classz){
        if(StringUtils.isEmpty(str) || classz == null){
            return  null;
        }
        try {
            return classz.equals(String.class)? (T)str : objectMapper.readValue(str,classz);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
