package com.vincent.thread;

/**
 * Created by chenjun on 2020-02-29 10:42
 */
public class ThreadTest {
    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("hello");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("world");
            }
        }).start();



        new Thread(() -> {
            synchronized (lock) {
                System.out.println("hello1");
                lock.notifyAll();
                System.out.println("开始睡觉");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡完了");
            }
        }).start();
    }
}
