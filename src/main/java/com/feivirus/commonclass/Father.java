package com.feivirus.commonclass;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.feivirus.fastjson.SongsEnum;

public class Father implements Serializable{
    protected SongsEnum songsEnum;
    protected Integer status = 1;

    public SongsEnum getSongsEnum() {
        System.out.println("father songs enum");
        return songsEnum;
    } 
    
    public static void main(String[] args) {
        Father father = new Father();
        father.songsEnum = SongsEnum.BETTER_MAN;
        
        String json = JSONObject.toJSONString(father);
        System.out.println(father);
        
        Father newFather = JSONObject.parseObject(json, Father.class);
        System.out.println(newFather);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setSongsEnum(SongsEnum songsEnum) {
        this.songsEnum = songsEnum;
    }    
}
