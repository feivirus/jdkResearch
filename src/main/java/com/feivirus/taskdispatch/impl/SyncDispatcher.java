package com.feivirus.taskdispatch.impl;

import static org.junit.Assert.fail;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.feivirus.taskdispatch.Dispatcher;
import com.feivirus.taskdispatch.Task;
import com.feivirus.taskdispatch.TaskManager;

import lombok.Data;
import lombok.Synchronized;

/**
 * 同步调度器, 方便dubbo类同步调用
 * @author feivirus
 *
 */
@Data
public class SyncDispatcher implements Dispatcher {
    private volatile Boolean running;    
    
    private TaskManager taskManager;
    
    public SyncDispatcher() {
        running = true;
    }    

    @Override
    public void addTask(Task task) {       
        
    }

    @Override
    public void removeTask(Task task) {
        
    }   

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void syncDispatch(Task task) {
        taskManager.processTask(task);
    }

    @Override
    public void asyncDispatch() {
       return;        
    }

    @Override
    public void addTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }     
}
