package com.feivirus.commonclass;

import java.io.Serializable;

public class StaticMemberSerial implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static Integer staticInt = 10;
    
    private Integer value = 15;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static Integer getStaticInt() {
        return staticInt;
    }

    public static void setStaticInt(Integer staticInt) {
        StaticMemberSerial.staticInt = staticInt;
    }   
}
