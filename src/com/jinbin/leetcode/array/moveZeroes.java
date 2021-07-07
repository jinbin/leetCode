package com.jinbin.leetcode.array;

import java.util.Arrays;

//https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/

public class moveZeroes {
    public void moveZeroes1(int[] nums) {
        int first = -1;
        int second = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && first == -1){
                first = i;
            }

            if(nums[i] != 0 && first != -1){
                second = i;
                break;
            }
        }

        if(first == -1 || second == -1){
            return;
        }

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

        while(true){
            while(nums[first] != 0){
                first++;
                if(first == nums.length){
                    return;
                }
            }

            while(nums[second] == 0){
                second++;
                if(second == nums.length){
                    return;
                }
            }

            int temp1 = nums[first];
            nums[first] = nums[second];
            nums[second] = temp1;
        }
    }

    public void moveZeroes2(int[] nums){
        int first = 0;
        int second = 0;

        while(true){
            while(nums[first] != 0){
                first++;
                if(first == nums.length){
                    return;
                }
            }

            second = first;
            while(nums[second] == 0){
                second++;
                if(second == nums.length){
                    return;
                }
            }

            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }
    }

    public static void main(String[] args){
        moveZeroes mz = new moveZeroes();
        int nums[] = {1,0,5,8,0,9};
        mz.moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));

        int nums2[] = {1,0,5,8,0,9};
        mz.moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
