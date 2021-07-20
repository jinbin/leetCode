package com.jinbin.leetcode.array;

import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum_closest = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int last = nums.length - 1;
                for(int j = i+1; j < nums.length; j++){
                    if(j == nums.length-1){
                        continue;
                    }

                    while(last > j && nums[i] + nums[j] + nums[last] > target){
                        last--;
                    }

                    if(last == j){
                        if(Math.abs(nums[i] + nums[j] + nums[last+1] - target) < closest){
                            closest = Math.abs(nums[i] + nums[j] + nums[last+1] - target);
                            sum_closest = nums[i] + nums[j] + nums[last+1];
                        }
                        continue;
                    }

                    if(last == nums.length-1){
                        if(Math.abs(nums[i] + nums[j] + nums[last] - target) < closest){
                            closest = Math.abs(nums[i] + nums[j] + nums[last] - target);
                            sum_closest = nums[i] + nums[j] + nums[last];
                        }
                    }else{
                        if(Math.abs(nums[i] + nums[j] + nums[last] - target) < closest){
                            closest = Math.abs(nums[i] + nums[j] + nums[last] - target);
                            sum_closest = nums[i] + nums[j] + nums[last];
                        }

                        if(Math.abs(nums[i] + nums[j] + nums[last+1] - target) < closest){
                            closest = Math.abs(nums[i] + nums[j] + nums[last+1] - target);
                            sum_closest = nums[i] + nums[j] + nums[last+1];
                        }
                    }
                }
            }
        }
        return sum_closest;
    }

    public static void main(String[] args){
        threeSumClosest tsc = new threeSumClosest();

        int[] nums = {-1,2,1,-4};
        System.out.println(tsc.threeSumClosest(nums, 1));
    }
}
