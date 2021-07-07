package com.jinbin.leetcode.array;

public class singleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result = result^nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        singleNumber sn = new singleNumber();
        int[] nums = {1,2,2,4,5,5,4};
        System.out.println(sn.singleNumber(nums));
    }
}
