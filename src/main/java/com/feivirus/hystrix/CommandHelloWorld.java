package com.feivirus.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author feivirus
 */
public class CommandHelloWorld extends HystrixCommand<String> {
    private String name;

    public CommandHelloWorld(HystrixCommandGroupKey groupKey, String name) {
        super(groupKey);
        this.name = name;
    }

    public CommandHelloWorld(Setter setter, String name) {
        super(setter);
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "Failure, " + name;
    }

    @Override
    protected String run() throws Exception {
        if ("Alice".equals(name))
            throw new RuntimeException("出错啦");
        return "Hello, " + name;
    }
}
