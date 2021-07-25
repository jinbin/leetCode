package com.jinbin.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

class SearchAndSave implements Runnable {
    public void run(){
        System.out.println("Running " + Thread.currentThread().getName());
        for(int i = 0; i < 5; i++){
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SearchDiff {
    private String url1;
    private String url2;

    public SearchDiff(String url1, String url2){
        this.url1 = url1;
        this.url2 = url2;
    }

    public void searchAndSave(String outfile) {
        //读取query
        //对query进行拆分，多线程进行处理
        //当所有线程完成处理，将结果汇总
        //序列化结果到文本中
    }
}

class SearchMultithreading implements Runnable {
    private String query;

    SearchMultithreading(String file){
        query = file;
    }

    public void run(){
        InputStream file = null;
        try {
            file = new FileInputStream("/Users/jinbin/Desktop/1.txt");
            BufferedInputStream br = new BufferedInputStream(file);
            int count;
            long begin = System.currentTimeMillis();
            while((count=br.read()) != -1){
                System.out.println("Available: " + br.available());
                System.out.println((char)count);
            }
            long end = System.currentTimeMillis();
            System.out.println("Search Time: " + (end - begin) + " ms\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class searchMulti {
    public static void main(String[] args){
        SearchMultithreading sm = new SearchMultithreading("1111");

        Thread t1 = new Thread(sm, "t1");
        t1.start();
    }
}
