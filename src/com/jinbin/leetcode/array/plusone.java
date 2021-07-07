package com.jinbin.leetcode.array;

import java.util.Arrays;

//https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/

public class plusone {
    public int[] plusOne(int[] digits) {
        int[] result = plusOne_part(digits, digits.length);

        if(result[0] == 0){
            int[] new_res = new int[digits.length + 1];
            for(int i = 0; i < result.length; i++){
                new_res[i+1] = result[i];
            }
            new_res[0] = 1;
            return new_res;
        }

        return result;
    }

    public int[] plusOne_part(int[] digits, int len){
        if(len == 0) {
            return digits;
        }else{
            if(digits[len-1] < 9){
                digits[len-1] = digits[len-1] + 1;
                return digits;
            }else{
                digits[len-1] = 0;
                return plusOne_part(digits, len-1);
            }
        }
    }

    public static void main(String[] args){
        plusone po = new plusone();
        int[] nums = {9};
        int[] result = po.plusOne(nums);

        System.out.println(Arrays.toString(result));

        int[] test = new int[nums.length + 1];

    }
}
