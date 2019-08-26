package com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain;

import java.util.Random;

import lombok.Data;

@Data
public class DefaultHandlerContext implements HandlerContext {
    //handler的开始处理时间
    private Long startTime;
    
    private boolean continueNextHandler = true;
    

    public String UUID() {
        Random random = new Random();
        return random.toString();
    }

    public boolean continueNextHandle() {
        return continueNextHandler;
    }

}
