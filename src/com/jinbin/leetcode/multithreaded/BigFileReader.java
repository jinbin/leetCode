package com.jinbin.leetcode.multithreaded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BigFileReader {
    private File file;
    private long fileLength;
    private int threadSize;
    private List<Long> breakpoints;
    CyclicBarrier barrier;
    RandomAccessFile rAccessFile;

    BigFileReader(File file, int threadSize) {
        this.file = file;
        this.fileLength = file.length();
        this.breakpoints = new ArrayList<>();
        this.threadSize = threadSize;
        try{
            this.rAccessFile = new RandomAccessFile(this.file,"r");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    long get_File_Len(){
        return fileLength;
    }

    public void set_breakpoints() throws IOException {
        long everySize = this.fileLength / this.threadSize;
        //long everySize = 100;
        System.out.println("everySize: " + everySize);
        breakpoints.add(0L);

        for(long i=everySize; i < this.fileLength;){
            rAccessFile.seek(i);
            byte tmp =(byte) rAccessFile.read();
            // 统一用char 来转换也可以
            // char tmp =(char) rAccessFile.read();
            // 只以一个'\n'或者'\r'进行分隔
            while(tmp!='\n' && tmp!='\r'){
                i++;
                if(i>=fileLength-1){
                    i=fileLength-1;
                    break;
                }
                rAccessFile.seek(i);
                tmp =(byte) rAccessFile.read();
            }
            if(i == fileLength-1) {
                breakpoints.add(i);
                break;
            }
            breakpoints.add(i+1);
            i = i + everySize;
            if(i >= this.fileLength){
                breakpoints.add(this.fileLength - 1);
                break;
            }
        }
    }

    public void set_breakpoints(int lines){
        if("line" == "line"){
            int line_num = lines / this.threadSize;
            for(int i = 0; i < lines; i=i+line_num){
                breakpoints.add((long) i);
            }
            if(breakpoints.get(breakpoints.size()-1) != lines - 1){
                breakpoints.set(breakpoints.size()-1, (long)lines-1);
            }
        }
    }

    private class Task implements Runnable{
        private long start;
        private long end;
        long everySize = 10;
        int bufferSize = 10;

        Task(long start, long end){
            this.start = start;
            this.end = end;
        }

        public void run(){
            System.out.println("running: " + Thread.currentThread().getName());
            long count = end - start + 1;
            RandomAccessFile rAccessFile = null;
            try {
                // 如果是rAccessFile为实例变量，则可能会互相干扰
                rAccessFile = new RandomAccessFile(file,"r");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                long skip_count = start;
                while(skip_count > 0){
                    rAccessFile.readLine();
                    skip_count--;
                }
                while(count > 0){
                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    //Thread.sleep(100);
                    String s = rAccessFile.readLine();
                    System.out.println(s);
                    count--;
                }
                barrier.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("ending: " + Thread.currentThread().getName());
        }
    }

    public void start() {
        final long startTime = System.currentTimeMillis();
        this.barrier = new CyclicBarrier(this.breakpoints.size() - 1, new Runnable() {
            @Override
            public void run() {
                System.out.println("use time: "+(System.currentTimeMillis()-startTime));
            }
        });

        //for(int i = 0; i < this.breakpoints.size() - 1; i++){
        for(int i = 0; i < threadSize; i++){
            Task task;
            if(i == 0){
                task = new Task(0, breakpoints.get(i+1));
            }else{
                task = new Task(breakpoints.get(i)+1, breakpoints.get(i+1));
            }
            Thread T = new Thread(task, "T" + i);
            T.start();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/jinbin/Desktop/2.txt");

        BigFileReader reader = new BigFileReader(file, 4);
        reader.set_breakpoints(18);

        System.out.println("设置完breakpoints: " + reader.breakpoints);
        System.out.println("开启线程数：" + reader.threadSize);
        reader.start();

//        RandomAccessFile rAccessFile = new RandomAccessFile(file,"r");
//        for(int i = 0; i < reader.breakpoints.size()-1; i++){
//            System.out.println(reader.breakpoints.get(i));
//            if(i == reader.breakpoints.size()-2){
//                String s;
//                while((s = rAccessFile.readLine()) != null){
//                    System.out.println(s);
//                }
//                //System.out.println(rAccessFile.getFilePointer());
//            }else{
//                int count = 7;
//                while(count > 0){
//                    String s = rAccessFile.readLine();
//                    System.out.println(s);
//                    count--;
//                }
//                //System.out.println(rAccessFile.getFilePointer());
//            }
//        }
//        for(int i = 0; i < reader.breakpoints.size() - 1; i++){
//            System.out.println(reader.breakpoints.get(i));
//            rAccessFile.seek(reader.breakpoints.get(i));
//            String str;
//            while((str = rAccessFile.readLine()) != null){
//                System.out.println(str);
//            }
//        }
//        for(int i = 0; i < readBuff.length; i++){
//            System.out.print((char)rAccessFile.read());
//        }
    }
}

