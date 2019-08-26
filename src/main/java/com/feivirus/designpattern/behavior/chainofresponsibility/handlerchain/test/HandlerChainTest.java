package com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.test;

import com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.DefaultHandlerContext;
import com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.Handler;
import com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.HandlerChain;
import com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain.HandlerChainImpl;

public class HandlerChainTest {
    
    public static void main(String[] args) {
        HandlerChain<DefaultHandlerContext> handlerChain = new HandlerChainImpl<>();
        Handler<DefaultHandlerContext> loggerHandler = new LoggerHandler();
        DefaultHandlerContext context = new DefaultHandlerContext();

        handlerChain.addHandler(loggerHandler);

        handlerChain.startHandle(context);
    }
}
