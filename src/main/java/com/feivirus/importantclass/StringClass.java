package com.feivirus.importantclass;

import java.util.ArrayList;
import java.util.List;

public class StringClass {
    public static void main(String[] args) {
        String str = "hello";
        StringBuilder sBuilder = new StringBuilder(str);
        StringBuffer sBuffer = new StringBuffer(str);
        String str1 = str + "world";
        
        String str2 = "world";
        List<String> strList = new ArrayList<String>();
        strList.add(str);    
        strList.add(str2);
        String str3 = String.join("", strList);
        System.out.println(str3);
        
        Integer intValue = 10;
        System.out.println("string valueof : " + String.valueOf(intValue));
        System.out.println("tostring: "+intValue.toString());
    }
    
    public static void testAdd() {
        String str1 = "hello";
        String result = str1 + "world";
    }
}
