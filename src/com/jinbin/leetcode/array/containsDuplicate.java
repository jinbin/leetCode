package com.jinbin.leetcode.array;

import java.util.Arrays;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 1){
            return false;
        }

        int check = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == check){
                return true;
            }
            check = nums[i];
        }

        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,3,3,4,3,2,4,2};

        containsDuplicate cd = new containsDuplicate();

        System.out.println(cd.containsDuplicate(nums));
    }
}
