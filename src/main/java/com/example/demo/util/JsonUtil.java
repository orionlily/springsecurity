package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * 使用jackson封装json工具类
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /** 
     * 
     * @Author: li.lc
     * @Description: Object转Json
     * @Date: 2019-06-04
     * @Param: 
     * @return: 
     */
    public static String ObjToJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    /**
     *
     * @Author: li.lc
     * @Description: JSON转实体类
     * @Date: 2019-06-04
     * @Param:
     * @return:
     */
    public static <T> T JsonToBean(String json,Class<T> clazz) throws IOException {
        return mapper.readValue(json,clazz);
    }

    /** 
     * 
     * @Author: li.lc
     * @Description: Json转List
     * @Date: 2019-06-04
     * @Param: 
     * @return: 
     */
    public static <T> List<T> JsonToList(String jsonArray ,Class<T> clazz) throws IOException {
       return (List<T>)mapper.readValue(jsonArray,getCollectionType(ArrayList.class,clazz));
    }

    /** 
     * 
     * @Author: li.lc
     * @Description: json转map
     * @Date: 2019-06-04
     * @Param: 
     * @return: 
     */
    public static <T> Map<String,T> JsonToMap(String json,Class<T> mapValueClass) throws IOException {
        return mapper.readValue(json,getCollectionType(HashMap.class,String.class,mapValueClass));
    }

    /** 
     * 
     * @Author: li.lc
     * @Description:
     * @Date: 2019-06-04
     * @Param: 
     * @return: 
     */
    //public static ArrayNode

    /** 
     * 
     * @Author: li.lc
     * @Description: 私有,获取javaType,用于转换
     * @Date: 2019-06-04
     * @Param: 
     * @return: 
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
