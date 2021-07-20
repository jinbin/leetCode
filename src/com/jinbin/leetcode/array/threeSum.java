package com.jinbin.leetcode.array;

import java.util.*;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // todo List 操作处理
        Arrays.sort(nums);

        List<List<Integer>> list_all = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                for(int j = i+1; j < nums.length; j++){
                    if(j == i+1 || nums[j] != nums[j-1]){
                        for(int z = j+1; z < nums.length; z++){
                            if(z == j+1 || nums[z] != nums[z-1]){
                                if(nums[i] + nums[j] + nums[z] == 0){
                                    List<Integer> list = new ArrayList<Integer>();
                                    list.add(nums[i]);
                                    list.add(nums[j]);
                                    list.add(nums[z]);
                                    list_all.add(list);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list_all;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        // todo List 操作处理
        Arrays.sort(nums);

        List<List<Integer>> list_all = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int z = nums.length - 1;

                for(int j = i+1; j < nums.length; j++){
                    if(j == i+1 || nums[j] != nums[j-1]){

                        while(z > j && nums[i] + nums[j] + nums[z] > 0){
                            z--;
                        }

                        if(j >= z){
                            break;
                        }

                        if(nums[i] + nums[j] + nums[z] == 0){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[z]);
                            list_all.add(list);
                        }
                    }
                }
            }
        }
        return list_all;
    }

    public static void main(String[] args){
        threeSum ts = new threeSum();
        int[] nums = {1,2,-2,-1};
        // -2, -1, 1, 2
        System.out.println(ts.threeSum1(nums));
    }
}
