package com.jinbin1;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int distance(String s1, String s2){
        // 第一个字母匹配上
        String first = s1.substring(0,1);
        int len1 = 0;
        int len2 = 0;
        int min_len1 = 1000000;
        for(int i = 0; i < s2.length(); i++){
            if(s2.substring(i,i+1).endsWith(first)){
                if(s1.length() == 1){
                    len1 = s2.length() - 1;
                }else {
                    // 匹配上，距离 = i + 之后匹配的距离
                    len1 = distance(s1.substring(1, s1.length()), s2.substring(i, s2.length())) + i;
                }
                if(len1 < min_len1){
                    min_len1 = len1;
                }
            }
        }

        // 第一个字母没有匹配上
        len2 = 1 + distance(s1.substring(1, s1.length()), s2);

        if(len1 < len2){
            return len1;
        }else{
            return len2;
        }
    }
}
