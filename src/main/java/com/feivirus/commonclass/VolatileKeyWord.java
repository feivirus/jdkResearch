package com.feivirus.commonclass;

/**
 * 
 * @author feivirus
 *
 */
public class VolatileKeyWord {
    int i = 0;
    boolean flag = false;
    
    public void read() {
        if (flag) {
            System.out.println("flag true");
        }
    }
    
    public void write() {
        i = 2;
        flag = true;
    }
    
	public static void main(String[] args) throws InterruptedException {
		PrintString printString = new PrintString();
		Thread thread = new Thread(printString);
		thread.start();
		Thread.sleep(1000);
		printString.setRunLoop(false);
		System.out.println("主线程终止");
	}
}

class PrintString implements Runnable{
	volatile private boolean isRunLoop = true;

	public boolean isRunLoop() {
		return isRunLoop;
	}

	public void setRunLoop(boolean isRunLoop) {
		this.isRunLoop = isRunLoop;
	}

	public void run() {
		try {
			while (isRunLoop) {
				//System.out.println("I am running, " + Thread.currentThread().getName());
				//Thread.sleep(1000);
			}
			System.out.println("子线程被终止");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}		
}
