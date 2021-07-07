package com.jinbin.leetcode.array;

import java.util.Arrays;

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int first = 0;
        int second = 0;

        while(true){
            if(nums[first] == nums[second]){
                second++;
                if(second == nums.length){
                    break;
                }
            }else{
                first++;
                nums[first] = nums[second];
            }
        }

        return first+1;
    }

    public static void main(String[] args){
        removeDuplicates rd = new removeDuplicates();

        int[] nums = {1, 2, 4, 5, 5, 5, 6, 6, 9};
        System.out.println(rd.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
