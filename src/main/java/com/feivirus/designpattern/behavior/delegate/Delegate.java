package com.feivirus.designpattern.behavior.delegate;

/**
 * 委托模式
 * 委托模式是用组合，代理模式是继承。组合优于继承.
 * @author feivirus
 *
 */
public class Delegate {
    public static void main(String []args) {
        BusinessDelegate delegate = new BusinessDelegate();
        
        delegate.lookupService("kafka");
        delegate.doTask();
    }
}
