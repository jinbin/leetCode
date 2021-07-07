package com.jinbin.leetcode.dp;

public class climbStairs {
    //n = 45: 1836311903
    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs1(int n){
        if(n == 1){
            return 1;
        }

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i < n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

    public static void main(String[] args){
        climbStairs cs = new climbStairs();

        System.out.println(cs.climbStairs(45));
        System.out.println(cs.climbStairs1(45));
    }
}
