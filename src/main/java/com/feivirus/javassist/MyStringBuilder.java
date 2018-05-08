package com.feivirus.javassist;

public class MyStringBuilder {    
 
    private String buildString(int length) {
        String result = "";
        
        for(int i = 0; i < length; i++) {
            result += (char) i % 26 + 'a';
        }
        return result;
    }
    
    public static void main(String[] argv) {
        MyStringBuilder myStringBuilder = new MyStringBuilder();
        String result = myStringBuilder.buildString(500);
        System.out.println(result);
    }
}
