package com.feivirus.designpattern.behavior.chainofresponsibility.handlerchain;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import lombok.Data;

@Data
public class HandlerChainImpl<T extends HandlerContext> implements HandlerChain<T> {

    private ReadWriteLock lock;

    private HandlerNode<T> head;

    private HandlerNode<T> tail;

    public HandlerChainImpl() {
        lock = new ReentrantReadWriteLock();
    }

    public void startHandle(T context) {
        lock.readLock().lock();
        HandlerNode<T> node = head;

        while (node != null) {
            Handler<T> handler = node.getHandler();

            handler.handle(context);
            if (!context.continueNextHandle()) {
                break;
            }
            node = node.getNextHandlerNode();
        }

        lock.readLock().unlock();
    }

    @Override
    public void addHandler(Handler<T> handler) {
        lock.writeLock().lock();
        if (head == null) {
            head = new HandlerNode<T>();

            head.setHandler(handler);
            head.setNextHandlerNode(null);
            tail = head;
        } else {
            HandlerNode<T> node = new HandlerNode<>();

            node.setHandler(handler);
            node.setNextHandlerNode(null);
            tail.setNextHandlerNode(node);
            tail = node;
        }

        lock.writeLock().unlock();
    }

    @Override
    public void removeHandler(Handler<T> handler) {
        lock.writeLock().lock();
        if (head == null) {
            lock.writeLock().unlock();
            return;
        }
        // 移除头结点
        if (head.getHandler().equals(handler)) {
            head = head.getNextHandlerNode();
            if (tail.getHandler().equals(handler)) {
                tail = null;
            }
            lock.writeLock().unlock();
            return;
        }

        HandlerNode<T> node = head;
        HandlerNode<T> prevNode = node;

        while (node != null) {
            if (node.getHandler().equals(handler)) {
                prevNode.setNextHandlerNode(node.getNextHandlerNode());

                // 移除最后一个节点
                if (node.equals(tail)) {
                    tail = prevNode;
                }
                break;
            }

            prevNode = node;
            node = node.getNextHandlerNode();
        }

        lock.writeLock().unlock();
    }

}
