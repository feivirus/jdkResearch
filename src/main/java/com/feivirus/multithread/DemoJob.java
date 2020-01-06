package com.feivirus.multithread;

import java.util.concurrent.locks.Lock;

/**
 * @author feivirus
 */
public class DemoJob implements Runnable {
    private Lock lock;
    private Integer jobId;

    public DemoJob(Lock lock, Integer jobId){
        this.lock = lock;
        this.jobId = jobId;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("job " + jobId + " finished");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
