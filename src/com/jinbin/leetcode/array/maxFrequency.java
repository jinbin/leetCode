package com.jinbin.leetcode.array;

import java.util.Arrays;

public class maxFrequency {
    //超时 
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int max_count = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            int k_copy = k;
            for(int j = i-1; j >= 0; j--){
                if(k_copy - (nums[i] - nums[j]) >= 0){
                    k_copy = k_copy - (nums[i] - nums[j]);
                    count++;
                }else{
                    break;
                }
            }
            if(count > max_count){
                max_count = count;
            }
        }

        return max_count;
    }

    public static void main(String args[]){
        maxFrequency mf = new maxFrequency();
        int[] nums = {3,9,6};
        System.out.println(mf.maxFrequency(nums, 2));
    }
}
