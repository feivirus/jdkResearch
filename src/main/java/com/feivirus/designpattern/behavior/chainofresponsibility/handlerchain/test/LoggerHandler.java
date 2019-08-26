package com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.test;

import com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.DefaultHandlerContext;
import com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.Handler;

public class LoggerHandler implements Handler<DefaultHandlerContext> {

    @Override
    public void handle(DefaultHandlerContext context) {
        System.out.println("i am loggerHandler");
    }
}
