package com.atguigu.threadlocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/8 17:59
 * @Version 1.0
 */
public class ThreadLocalTest {
    //public final static Map<String, Object> data = new ConcurrentHashMap<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal1 = new ThreadLocal<>();

    private static Random random = new Random();
    public static class Task implements Runnable {

        @Override
        public void run() {
            threadLocal.set("abc");
            threadLocal1.set("def");
            System.out.println(threadLocal.get());
            System.out.println(threadLocal1.get());

            /*int i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("Thread: " + name + "Random number is: " + i);
            //data.put(name, i);
            threadLocal.set(i);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            new OrderService().createOrder();

            Object o = threadLocal.get();

            System.out.println("Thread: " + name + "is Terminated and the number is " + o);*/
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}
