package com.feivirus.multithread;

/**
 * 
 * @author feivirus
 * 写volatile变量,线程本地变量会刷新到主内存
 * 读volatile的变量,线程本地变量会置无效,从主内存读取值
 * @see http://novoland.github.io/%E5%B9%B6%E5%8F%91/2014/07/26/Java%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B.html
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
