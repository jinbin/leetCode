package com.jinbin.leetcode.array;

import java.util.Arrays;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        // Java数据拷贝 clone
        int[] nums_cooy = nums.clone();

        Arrays.sort(nums_cooy);

        int first = 0;
        int last = nums_cooy.length - 1;

        while(first != last){
            int sum = nums_cooy[first] + nums_cooy[last];
            if(sum == target){
                break;
            }else if(sum > target){
                last--;
            }else if(sum < target){
                first++;
            }
        }

        int init_first = -1;
        int init_last = -1;
        for(int i = 0; i < nums.length; i++){
            if(init_first == -1 && nums[i] == nums_cooy[first]){
                init_first = i;
                continue;
            }
            if(init_last == -1 && nums[i] == nums_cooy[last]){
                init_last = i;
                continue;
            }
        }

        int result[] = {init_first, init_last};
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};

        twoSum ts = new twoSum();

        System.out.println(Arrays.toString(ts.twoSum(nums, 9)));
    }
}
