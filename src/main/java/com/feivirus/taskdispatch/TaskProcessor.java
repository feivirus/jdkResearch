package com.feivirus.taskdispatch;

import com.feivirus.taskdispatch.impl.TaskResult;

/**
 * 任务处理器
 * @author feivirus
 * 后期加pre,post拦截
 */
public interface TaskProcessor<R, P extends Task> {
    TaskResult<R> process(P task);
}
