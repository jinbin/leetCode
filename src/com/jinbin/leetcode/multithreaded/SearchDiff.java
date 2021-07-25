package com.jinbin.leetcode.multithreaded;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner implements Runnable{
    public void run() {
        System.out.println("running: " + Thread.currentThread().getName());
    }
}

public class SearchDiff {


    public static void main(String[] args){
        // newFixedThreadPool的参数指定了可以运行的线程的最大数目
        // 超过这个数目的线程加进去以后，不会立即运行，而是被放入任务队列中等待执行。
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Runner r = new Runner();
        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        Thread t3 = new Thread(r, "T3");

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);

        pool.shutdown();
    }
}
