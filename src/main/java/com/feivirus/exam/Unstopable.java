package com.feivirus.exam;

public class Unstopable extends Thread {
    private boolean stop = false;

    @Override
    public void run() {
        int i = 0;
      
        while (!stop) {          
            //System.out.print("hello");
            i++;
            if (i > 1000000) {
                //System.out.print("hello");
            }
        }
        System.out.println("run finish " + i);
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
    public static void main(String [] args) throws Exception{
        Unstopable unstopable = new Unstopable();
        unstopable.start();
        
        Thread.sleep(1000);
        unstopable.setStop(true);
        Thread.sleep(2000);
        
        System.out.println("main finish " + unstopable.isStop());
    }
}
