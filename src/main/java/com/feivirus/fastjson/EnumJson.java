package com.feivirus.fastjson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 参考思路:https://blog.csdn.net/tang9140/article/details/51701099
 * @author feivirus
 *
 */
public class EnumJson {
    
    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(SongsEnum.BETTER_MAN));
        System.out.println(JSONObject.toJSONString(SongsEnum.STYLE, SerializerFeature.WriteEnumUsingToString));
        
        SerializeConfig config = new SerializeConfig();
        config.configEnumAsJavaBean(SongsEnum.class);
        System.out.println(JSONObject.toJSONString(SongsEnum.SHAKE_IT_OFF, config));
       
        Song song = new Song();
        
        song.setName("titanic");
        song.setSongsEnum(SongsEnum.BETTER_MAN);
        song.setStatusEnum(SongsStatusEnum.LEGAL_COPY);
        System.out.println(JSONObject.toJSONString(song, config));
        
        SongsEnum[] songsEnums = {SongsEnum.BETTER_MAN, SongsEnum.SAFE_AND_SOUND, SongsEnum.SHAKE_IT_OFF};
        
        System.out.println(JSONObject.toJSONString(songsEnums, config));
        
        SongsEnum[] values = SongsEnum.values();
        List<SongsEnum> songsEnumList = new ArrayList<SongsEnum>();
        for (SongsEnum value : values) {
            songsEnumList.add(value);
        }
        System.out.println(JSONObject.toJSONString(songsEnumList, config));
        
        System.out.println(JsonUtil.toJson(SongsEnum.class));
    }
}
