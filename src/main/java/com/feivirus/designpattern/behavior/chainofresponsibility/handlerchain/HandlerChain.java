package com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain;

public interface HandlerChain<T extends HandlerContext> {
    void startHandle(T context);
    
    void addHandler(Handler<T> handler);
    
    void removeHandler(Handler<T> handler);
}
