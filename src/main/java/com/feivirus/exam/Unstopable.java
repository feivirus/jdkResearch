package com.feivirus.exam;

/**
 * 
 * @author feivirus
 * -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:CompileCommand=dontinline,*Unstopable.run 
 * -XX:CompileCommand=compileonly,*Unstopable.run -XX:+PrintAssembly
 */
public class Unstopable extends Thread {
    private boolean stop = false;

    @Override
    public void run() {
        int i = 0;
      
        while (!stop) {          
            //System.out.print("hello");
            i++;
            if (i > 10000000) {
                //System.out.print("hello");
               // break;
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
