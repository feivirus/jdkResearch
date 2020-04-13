package com.feivirus.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author feivirus
 */
public class TempLambda {
    private Integer value;

    public static void main(String[] args) {
        //basicInterface();
        //sample();
        streamSample();
    }

    /**
     * 1. 无参无返回值
     */
    public static void basicInterface() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r1");
            }
        };

        Runnable r2 = () -> {
            System.out.println("r2");
        };

        processRunnable(r1);
        processRunnable(r2);
        processRunnable(() -> {
            System.out.println("r3");
        });
    }

    public static void processRunnable(Runnable runnable) {
        runnable.run();
    }

    /**
     * 2.自定义functional interface
     */
    @FunctionalInterface
    public interface IStringLen {
        int length(String value);
    }

    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    @FunctionalInterface
    public interface Getter<V> {
        V get();
    }

    public static void sample() {
        IStringLen i1 = (s) -> s.length();

        proessOneParam(i1);

        proessOneParam((v) -> {return v.hashCode();});

        processTwoParams((v1, v2) -> {return v1 * v2;});

        processNoParam( new TempLambda()::getValue);
    }

    public static void processNoParam(Getter getter) {
        System.out.println("getter: " + getter.get());
    }

    public static void proessOneParam(IStringLen len) {
        System.out.println(len.length("1223"));
    }

    public static void processTwoParams(Adder adder) {
        System.out.println(adder.add(11, 23));
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 3.处理流
     */
    public static void streamSample() {
        List<Integer> ageList = Arrays.asList(1, 20, 30, 40);

        List<Integer> result = ageList.stream().filter((a)-> { return a % 2 == 0;}).collect(Collectors.toList());
        if (!result.isEmpty()) {
            result.forEach((i) -> {
                System.out.println(i);
            });
        }
    }
}
