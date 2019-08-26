package com.feivirus.taskdispatch;

/**
 * 调度接口
 * @author feivirus
 * 支持同步和异步调度
 */
public interface Dispatcher {
    void addTask(Task task);
    
    void removeTask(Task task);    
    
    /**
     * 同步调度
     * @param task
     */
    void syncDispatch(Task task);    
    
    /**
     * 异步调度
     */
    void asyncDispatch();
    
    void stop();
    
    boolean isRunning();
    
    void addTaskManager(TaskManager taskManager);
}
