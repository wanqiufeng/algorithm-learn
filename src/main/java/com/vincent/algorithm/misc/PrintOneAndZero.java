package com.vincent.algorithm.misc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 交替打印0和1 ，美团面试题
 */
public class PrintOneAndZero {
    public static void main(String[] args) {
        method1();
    }


    /**
     * 思路：
     * 1.要交替打印，那么肯定是死循环
     * 2.线程1要输出1后，线程2才能输出0.那意味着线程之间肯定有线程同步，需要使用一个共享变量去判断
     * 3.所以这里使用AtomicInteger作为flag，保证两个线程使用这个共享变量时，线程可见。
     * 4.每个线程再使用后，修改变量值，使得另外一个线程可以继续打印使用
     */
    public static void method1(){
        AtomicInteger flag = new AtomicInteger(1);
        new Thread(() -> {
            while (true) {
                if(flag.get() == 1) {
                    System.out.println(1);
                    flag.set(0);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if(flag.get() == 0) {
                    System.out.println(0);
                    flag.set(1);
                }
            }
        }).start();
    }


}
