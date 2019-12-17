package com.feivirus.oom;

/**
 * @author feivirus
 */
public class StackOverFlow {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        System.out.println("stack length " + stackLength);
        stackLeak();
    }

    public static void main(String[] args) {
        StackOverFlow flow = new StackOverFlow();
        try {
            flow.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length " + flow.stackLength);
            throw  e;
        }

    }
}
