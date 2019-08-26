package com.feivirus.taskdispatch.test;

import com.feivirus.taskdispatch.Dispatcher;
import com.feivirus.taskdispatch.Task;
import com.feivirus.taskdispatch.TaskManager;
import com.feivirus.taskdispatch.TaskProcessor;
import com.feivirus.taskdispatch.enums.TaskType;
import com.feivirus.taskdispatch.impl.SyncDispatcher;
import com.feivirus.taskdispatch.impl.TaskManagerBase;
import com.feivirus.taskdispatch.impl.TaskResult;

/**
 * 通用任务调度模型启动
 * 
 * @author feivirus
 *
 */
public class Bootstrap {
    public static void main(String[] args) {
         Dispatcher dispatcher = new SyncDispatcher();
         Task task = new CreateGPSTask();
         TaskProcessor taskProcessor = new CreateGPSProcessor();   
         TaskManager taskManager = new TaskManagerBase();
         
         taskManager.addProcessor(TaskType.CREATE_GPS, taskProcessor);    
         dispatcher.addTaskManager(taskManager);
         
         dispatcher.syncDispatch(task);         
    }
}
