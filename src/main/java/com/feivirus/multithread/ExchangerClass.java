package com.feivirus.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author feivirus
 * Exchanger对象理解为一个包含两个格子的容器，通过exchanger方法可以向两个格子中填充信息。当两个格子中的均被填充时，
 * 该对象会自动将两个格子的信息交换，然后返回给线程，从而实现两个线程的信息交换。
 */
public class ExchangerClass {

    static class Producer implements Runnable {
        private List<String> buffer;

        private Exchanger<List<String>> exchanger;

        Producer(List<String> buffer, Exchanger exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for(int i = 1; i < 5; i++) {
              System.out.println("生产者第" + i + " 次提供");

              for(int j = 1; j <= 3; j++) {
                  System.out.println("生产者装入 " + i + "--" + j);
                  buffer.add("buffer: " + i + "--" + j);
              }

              System.out.println("生产者装满,等待与消费者交换...");

              try {
                  //等待消费者也调用exchange时,交换buffer.
                  exchanger.exchange(buffer);
              } catch (InterruptedException ex) {
                  ex.printStackTrace();
              }
            }
        }
    }

    static class Consumer implements Runnable {
        private List<String> buffer;

        private final Exchanger<List<String>> exchanger;

        Consumer(List<String> buffer, Exchanger exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                System.out.println("消费者第 " + i + " 次提取");
                for(int j = 1; j <= 3; j++) {
                    System.out.println("消费者:" + buffer.get(0));
                    buffer.remove(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();
        Thread producer = new Thread(new Producer(buffer1, exchanger));
        Thread consumer = new Thread(new Consumer(buffer2, exchanger));

        producer.start();
        consumer.start();
    }
}


