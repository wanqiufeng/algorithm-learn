package com.vincent.thread;

/**
 * Created by chenjun on 2020-02-29 11:21
 */
public class TestInterruptingThread1 extends Thread{
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("task");
        } catch(InterruptedException e){
            throw new RuntimeException("Thread interrupted..."+e);
        }

    }

    public static void main(String args[]){
        TestInterruptingThread1 t1=new TestInterruptingThread1();
        t1.start();
        t1.interrupt();
    }
}
