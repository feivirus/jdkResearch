package com.feivirus.commonclass;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.feivirus.fastjson.SongsEnum;

public class Child extends Father{    
    protected Integer status = 2;
    
    @JSONField(name = "songs")
    public String getSongs() {
        return songsEnum.name;
    }

    @JSONField(name = "songs")
    public void setSongs(String songs) {
        songsEnum = SongsEnum.getEnumByName(songs);
    }

    @JSONField(serialize = false)
    public void setSongsEnum(SongsEnum songsEnum) {
        this.songsEnum = songsEnum;
    }   
    
    @JSONField(serialize = false)
    public SongsEnum getSongsEnum() {
        System.out.println("child songs enum");
        return songsEnum;
    }
    
    public void show() {
        System.out.println("supser status " + super.status);
        System.out.println("child status " + status);
    }
    
    public static void main(String[] args) {
        Child child = new Child();
        
        child.setSongsEnum(SongsEnum.BETTER_MAN);
        child.show();
        String jsonRet = JSONObject.toJSONString(child);
        System.out.println("json " + jsonRet);
        Child newChild = JSONObject.parseObject(jsonRet, Child.class);
        
        System.out.println(newChild.getSongsEnum());
        System.out.println("status : " + newChild.status);
        newChild.show();
    }
}
