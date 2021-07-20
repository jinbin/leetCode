package com.jinbin.leetcode.dp;

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 1;
        int full_max = 1;

        for(int i = 1; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i] > full_max){
                full_max = dp[i];
            }
        }

        return full_max;
    }

    public static void main(String[] args){
        lengthOfLIS len = new lengthOfLIS();

        int[] nums = {1,2,3,0, -1, 5, 6, 3, 2,10};
        System.out.println(len.lengthOfLIS(nums));

        int[] nums1 = {1};
        System.out.println(len.lengthOfLIS(nums1));

        String astr = "aaaaa";
        int move = (int)(astr.charAt(1)) - (int)'a';
    }
}
