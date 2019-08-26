package com.feivirus.taskdispatch.impl;

import com.feivirus.taskdispatch.Task;
import com.feivirus.taskdispatch.enums.TaskType;

/**
 * 
 * @author feivirus
 *
 */
public class BaseTask implements Task {
    
    protected TaskType taskType;

    @Override
    public TaskType getType() {
        return taskType;
    }
    
}
