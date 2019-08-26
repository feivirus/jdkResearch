package com.feivirus.taskdispatch;

import com.feivirus.taskdispatch.enums.TaskType;

/**
 * 任务管理器
 * @author feivirus
 *
 */
public interface TaskManager {
    void addProcessor(TaskType taskType, TaskProcessor processor);
    
    void removeProcessor(TaskProcessor processor);
    
    void removeProcess(TaskType taskType);
    
    void processTask(Task task);
}
