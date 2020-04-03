package com.jinbin.basic;

import java.util.Arrays;

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

    //插入排序
    //时间复杂度O(n^2)
    public int[] insertionSort(int[] nums){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(nums, nums.length);

        for(int i = 1; i < arr.length; i++){
            int flag_value = nums[i];
            int flag = i;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] > flag_value){
                    arr[j + 1] = arr[j];
                    flag = j;
                }else{
                    break;
                }
            }
            arr[flag] = flag_value;
        }
        return arr;
    }

    //希尔排序
    public int[] shellSort(int[] nums){
        int[] arr = Arrays.copyOf(nums, nums.length);

        int interval = 1;
        while(interval < arr.length / 3){
            interval = interval * 3 + 1;
        }

        while(interval > 0){
            for(int i = 0; i < interval; i++){
                //针对i, i+interval, i+interval*2 ... 进行插入排序
                for(int j = i + interval; j < arr.length; j = j + interval){
                    // 从 j 位开始依次跟前面元素比较
                    int flag_value = arr[j];
                    int flag = j;
                    // index > 0 => index >= 0
                    System.out.println(Arrays.toString(arr));
                    for(int index = j - interval; index >= 0; index = index - interval){
                        if(flag_value < arr[index]){
                            arr[index + interval] = arr[index];
                            flag = index;
                        }else{
                            break;
                        }
                    }
                    arr[flag] = flag_value;
                }
            }
            interval = interval / 2;
        }
        return arr;
    }
}
