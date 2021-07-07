package com.jinbin.leetcode.dp;

public class NumArray {
    public int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length+1];
        sums[0] = 0;

        for(int i = 0; i < nums.length; i++){
            sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,-5};
        NumArray na = new NumArray(nums);

        System.out.println(na.sumRange(0,0));
    }
}
