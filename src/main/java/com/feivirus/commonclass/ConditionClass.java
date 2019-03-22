package com.feivirus.commonclass;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionClass {
    public static void main(String []args) {
       Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        
        //condition.await();
        condition.notify();
    }
}
