package com.feivirus.multithread;

import java.io.Serializable;

/**
 * @author feivirus
 */
public class DemoTask implements Runnable, Serializable {
    private Object valueState;

    public DemoTask(Object valueState) {
        this.valueState = valueState;
    }

    @Override
    public void run() {
        System.out.println("DemoTask start process task..." + valueState);
        try {
            Thread.sleep(500000000);
            //Thread.sleep(5000);
            System.out.println("DemoTask finish task..." + valueState);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return valueState.toString();
    }
}
