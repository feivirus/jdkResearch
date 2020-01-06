package com.feivirus.multithread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionClass {


    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        final Condition condition = lock.newCondition();

        LinkedList<String> buffer;

        Integer maxSize;
    }
}

class Consumer extends Thread {
    private Lock lock;

    private Condition condition;

    private LinkedList<String> buffer;

    private Integer maxSize;

    Consumer(Integer maxSize, LinkedList<String> buffer, Lock lock, Condition condition) {
        this.lock = lock;
        this.maxSize = maxSize;
        this.condition = condition;
        this.buffer = buffer;
    }

    private void consume() {
        try {
            //为啥要加锁?加了锁，只能有一个消费者进来
            lock.lock();
            while (buffer.size() == 0) {
                sleep(1000);
            }
            String result = buffer.poll();
            System.out.println("等待信号消费 " + this.getName() + " " + result);
            condition.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("消费完信号 " + this.getName());
            lock.unlock();
        }
    }

    @Override
    public void run() {
        consume();
    }
}

class Producer extends Thread {
    private Lock lock;

    private Condition condition;

    private LinkedList<String> buffer;

    private Integer maxSize;

    Producer(Integer maxSize, LinkedList<String> buffer, Lock lock, Condition condition) {
        this.lock = lock;
        this.maxSize = maxSize;
        this.condition = condition;
        this.buffer = buffer;
    }

    private void produce(String goods) {
        try {
            lock.lock();
            while (maxSize == buffer.size()) {
                sleep(1000);
            }
            System.out.println("生产信号");
            buffer.add(goods);
            condition.signalAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("生成完成信号");
        }
    }

    @Override
    public void run() {
        String goods = "goods";
        produce(goods);
    }
}
