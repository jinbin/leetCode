package com.jinbin.leetcode.dp;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + Math.max(dp[i-1], 0);
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args){
        maxSubArray msa = new maxSubArray();

        int[] nums = {1,2,3,-4,5,6,-18,9,10};
        System.out.println(msa.maxSubArray(nums));
    }
}
