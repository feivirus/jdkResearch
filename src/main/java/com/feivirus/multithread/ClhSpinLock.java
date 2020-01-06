package com.feivirus.multithread;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author feivirus
 * clh自旋锁，是个人名,AQS队列用的锁是clh锁的变种
 */
public class ClhSpinLock implements Lock {
    private volatile ThreadLocal<Node> threadLocal;
    private AtomicReference<Node> tail;

    public ClhSpinLock() {
        this.tail = new AtomicReference<>();
        this.threadLocal = new ThreadLocal<>();
    }

    @Override
    public void lock() {
        Node curNode = threadLocal.get();
        if (curNode == null) {
            curNode = new Node();
            threadLocal.set(curNode);
        }

        //在这一步把多个线程节点连接起来，当前节点只等待
        //前一个节点的锁状态.前一个节点释放时，当前节点
        //退出自旋状态
        Node prevNode = tail.getAndSet(curNode);
        if (prevNode != null) {
            while (prevNode.isLocked()) {

            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        Node curNode = threadLocal.get();
        threadLocal.remove();

        if (curNode == null || curNode.isLocked() == false) {
            return;
        }

        if (!tail.compareAndSet(curNode, null)) {
            curNode.setLocked(false);
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    class Node {
        private volatile boolean locked = true;

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }
    }


    public static void main(String[] args) {
        final Lock clLock = new ClhSpinLock();

        for (int i = 0; i < 10; i++) {
            new Thread(new DemoJob(clLock, i)).start();
        }
    }
}
