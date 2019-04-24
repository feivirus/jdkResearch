package com.feivirus.fastjson;

public enum SongsStatusEnum {
    ILLEGAL_COPY(0, "盗版"),
    
    LEGAL_COPY(1, "正版");
    
    
    private Integer key;
    
    private String value;    
    
    private SongsStatusEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
}
