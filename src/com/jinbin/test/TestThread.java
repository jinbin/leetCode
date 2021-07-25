package com.jinbin.test;

class RunnableDemo implements Runnable {
    public void run() {
        System.out.println("Running " +  Thread.currentThread().getName() );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + Thread.currentThread().getName() + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println("Thread " +  Thread.currentThread().getName() + " exiting.");
    }
}

class ThreadDemo extends Thread {
    private String threadName;

    ThreadDemo(String name){
        threadName = name;
        System.out.println("Creating " +  threadName);
    }

    public void run(){
        System.out.println("Running " +  threadName);
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
}

public class TestThread {
    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T1.start();
        T2.start();

        RunnableDemo demo = new RunnableDemo();
        Thread R1 = new Thread(demo, "Thread-Runnable-1");
        Thread R2 = new Thread(demo, "Thread-Runnable-2");
        R1.start();
        R2.start();
    }
}
