package com.vincent.thread;

/**
 * Created by chenjun on 2020-02-29 18:16
 */
public class SychronizedTest {
    public static void main(String[] args) {
        Object lock = new Object();

        synchronized (lock) {
            new Thread(() -> {
                synchronized (lock) {
                    System.out.println("hello");
                }
            }).start();
        }

        synchronized (lock) {
            synchronized (lock) {
                System.out.println("world");
            }
        }


    }
}
