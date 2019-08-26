package com.feivirus.taskdispatch.test;

import com.feivirus.taskdispatch.Task;
import com.feivirus.taskdispatch.TaskProcessor;
import com.feivirus.taskdispatch.impl.TaskResult;

public class CreateGPSProcessor implements TaskProcessor<Boolean, CreateGPSTask> {
    
    public CreateGPSProcessor() {
    }

    @Override
    public TaskResult<Boolean> process(CreateGPSTask task) {
        System.out.println("经纬度入库 : " + task.getLatitude() + " " + task.getLongitude());
        
        return new TaskResult<Boolean>();
    }  
}
