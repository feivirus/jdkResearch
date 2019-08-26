package com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain;

public interface Handler<T extends HandlerContext> {
    void handle(T context);
}
