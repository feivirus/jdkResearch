package com.feivirus.exam;

public class MyOperation implements IOperation {

    private int i = 0;

    @Override
    public void doSomething() {
        //System.out.println("MyOperation doSomething");
        i++;
    }
}
