package com.jinbin.leetcode.multithreaded;

import org.json.JSONObject;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException {
        File f = new File("/Users/jinbin/Desktop/3.txt");
        if(!f.exists()){
            f.createNewFile();
        }

        FileOutputStream fs = new FileOutputStream(f, true);
        ObjectOutputStream os = new ObjectOutputStream(fs);

        JSONObject o = new JSONObject();
        o.put("key", "value");
        o.put("key1", "value1");
        o.put("key2", "value2");
        os.writeObject(o.toString());
        //os.writeObject("hello world");

        RandomAccessFile rAccessFile = new RandomAccessFile(f, "r");
        rAccessFile.seek(10);
        char c = (char)rAccessFile.read();

        System.out.println(c);
    }
}
