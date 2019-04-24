package com.feivirus.fastjson;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;

public class JsonUtil {
    
    public static String toJson(Class<? extends Enum> enumsClass) {
        try {
            Method methodValues = enumsClass.getMethod("values");
            Object enumResult = methodValues.invoke(null);
            int length = Array.getLength(enumResult);
            List<Object> values = new ArrayList<Object>();
            
            for(int i = 0; i < length; i++) {
                values.add(Array.get(enumResult, i));
            }
            
            SerializeConfig config = new SerializeConfig();
            
            config.configEnumAsJavaBean(enumsClass);
            
            return JSONObject.toJSONString(values, config);
            
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
