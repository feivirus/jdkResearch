package com.feivirus.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;

import static org.junit.Assert.assertEquals;

/**
 * @author feivirus
 */
public class CommandHelloWorldTest {
    public static void main(String[] args) {
        testSync();
    }

    public static void testSync() {
        HystrixCommandGroupKey hystrixCommandGroupKey = HystrixCommandGroupKey.Factory.asKey("ExampleGroup");
        CommandHelloWorld command = new CommandHelloWorld(hystrixCommandGroupKey, "World");
        String result = command.execute();
        assertEquals("Hello, World", result);
    }
}
