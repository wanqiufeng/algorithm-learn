package com.vincent.thread;

/**
 * Created by chenjun on 2020-03-10 22:10 ，变量可见性测试
 */
public class VariableVisibleTest {

    private static boolean initFlag = false;

    public static void monitor() {
        while (!initFlag) {

        }

        System.out.println("监听状态被另外的线程更改就行啦");
    }


    public static void modifyFlag() {
        initFlag = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> monitor());
        threadA.start();

        Thread.sleep(5000l);

        Thread threadB = new Thread(() -> modifyFlag());
        threadB.start();
    }
}


