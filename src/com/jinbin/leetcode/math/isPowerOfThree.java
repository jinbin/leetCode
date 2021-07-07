package com.jinbin.leetcode.math;

public class isPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }

        while(n != 1){
            if(n % 3 != 0){
                return false;
            }
            n = n / 3;
        }
        return true;
    }

    public static void main(String[] args){
        isPowerOfThree it = new isPowerOfThree();

        System.out.println(it.isPowerOfThree(27));
    }
}
