package com.feivirus.taskdispatch.test;

import com.feivirus.taskdispatch.Task;
import com.feivirus.taskdispatch.enums.TaskType;
import com.feivirus.taskdispatch.impl.BaseTask;

import lombok.Data;

/**
 * 
 * @author feivirus
 *
 */
@Data
public class CreateGPSTask extends BaseTask {
    private Integer longitude;
    
    private Integer latitude;

    public CreateGPSTask() {
        this.taskType = TaskType.CREATE_GPS;
        this.latitude = 1;
        this.longitude = 20;
    }
    
    
    
    
}
