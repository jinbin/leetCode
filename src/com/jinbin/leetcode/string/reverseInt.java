package com.jinbin.leetcode.string;

public class reverseInt {
    public int reverse(int x) {
        int reverse = 0;
        while(x!=0){
            int left = x % 10;
            int res = reverse * 10 + left;
            //用这一步判断是否溢出
            if((res - left) / 10 != reverse){
                return 0;
            }
            reverse = res;
            x = x / 10;
        }
        return reverse;
    }
}
