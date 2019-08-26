package com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain;

import lombok.Data;

@Data
public class HandlerNode<T extends HandlerContext> {
    
    private Handler<T> handler;
    
    private HandlerNode<T> nextHandlerNode;
}
