package com.jinbin.basic;

// https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
public class Basics {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //从小到大排序
    //时间复杂度O(n^2)
    public int[] bubblesort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }

        return nums;
    }

    //选择排序
    //时间复杂度O(n^2)
    public int[] selectionSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int flag = i;
            for(int j = i; j < nums.length; j++){
                //找出最小值，跟第i位互换
                if(nums[j] < nums[flag]){
                    flag = j;
                }
            }
            if(flag != i){
                swap(nums, flag, i);
            }
        }
        return nums;
    }
}
