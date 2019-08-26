package com.feivirus.taskdispatch.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.feivirus.taskdispatch.Task;
import com.feivirus.taskdispatch.TaskManager;
import com.feivirus.taskdispatch.TaskProcessor;
import com.feivirus.taskdispatch.enums.TaskType;
import lombok.Data;

@Data
public class TaskManagerBase implements TaskManager {
    public Map<TaskType, TaskProcessor> processorMap;
    
    public TaskManagerBase() {
        processorMap = new ConcurrentHashMap();
    }

    @Override
    public void addProcessor(TaskType taskType, TaskProcessor processor) {
        processorMap.put(taskType, processor);
    }

    @Override
    public void removeProcessor(TaskProcessor processor) {
        Iterator<Map.Entry<TaskType, TaskProcessor>> iterator = processorMap.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<TaskType, TaskProcessor> entry = iterator.next();
            
            if (entry.getValue().equals(processor)) {
                iterator.remove();
            }            
        }        
    }

    @Override
    public void processTask(Task task) {
        TaskProcessor processor = processorMap.get(task.getType());
        
        if (processor != null) {
            processor.process(task);
        }
    }

    @Override
    public void removeProcess(TaskType taskType) {
        processorMap.remove(taskType);
    }            
}
