package com.jinbin.leetcode.sort;

import java.util.Arrays;

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = m-1+i; j >= 0; j--){
                if(nums2[i] >= nums1[j]){
                    nums1[j+1] = nums2[i];
                    break;
                }else{
                    nums1[j+1] = nums1[j];
                    if(j == 0){
                        nums1[0] = nums2[i];
                    }
                }
            }
        }
    }

    public void merge1(int[] m, int m_len, int[] n, int n_len){
        if(n_len == 0){
            return;
        }

        for(int i = 0; i < n_len; i++){
            for(int j = m_len - 1 + i; j >= 0; j--){
                if(n[i] <= m[j]){
                    m[j+1] = m[j];
                    if(j == 0){
                        m[0] = n[i];
                    }
                }else{
                    m[j+1] = n[i];
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] m = {4,5,6,0,0,0};
        int[] n = {};

        mergeSortedArray msa = new mergeSortedArray();
        msa.merge1(m, 3, n, 0);

        System.out.println(Arrays.toString(m));
    }
}
