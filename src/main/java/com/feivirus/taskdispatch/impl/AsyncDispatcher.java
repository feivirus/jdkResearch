package com.feivirus.taskdispatch.impl;

import java.util.concurrent.ExecutorService;

import com.feivirus.taskdispatch.Dispatcher;
import com.feivirus.taskdispatch.Task;
import com.feivirus.taskdispatch.TaskManager;

/**
 * 异步调度器, 方便消息队列使用
 * @author feivirus
 *
 */
public class AsyncDispatcher implements Dispatcher {
   

    @Override
    public void addTask(Task task) {
        
    }

    @Override
    public void removeTask(Task task) {
        
    }    

    @Override
    public void syncDispatch(Task task) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void asyncDispatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isRunning() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void stop() {
        
    }

    @Override
    public void addTaskManager(TaskManager taskManager) {
        // TODO Auto-generated method stub
        
    }      
}
