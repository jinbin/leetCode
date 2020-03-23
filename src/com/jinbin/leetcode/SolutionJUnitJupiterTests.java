package com.jinbin.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionJUnitJupiterTests {
    Solution s = new Solution();

    @Test
    void test_字符串距离_相等字符串比较(){
        String s1 = "abc";
        String s2 = "abc";

        int len1 = s1.length();
        int len2 = s2.length();

        assertEquals(0, s.minDistance(s1, len1, s2, len2));
    }

    @Test
    void test_字符串距离_空字符串比较(){
        String s1 = "";
        String s2 = "";

        int len1 = s1.length();
        int len2 = s2.length();

        assertEquals(0, s.minDistance(s1, len1, s2, len2));
    }

    @Test
    void test_寻找矩阵中所有正方形_case1(){
        int[][] matrix = {
                {1,1,1,0},
                {1,1,1,0},
                {1,1,1,1},
                {0,0,1,1}
        };

        System.out.println(s.find_matrix_num(matrix));
    }

    @Test
    void test_寻找矩阵中最大面积_case1(){
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        assertEquals(6, s.maxAreaOfIsland(grid));
    }

    @Test
    void test_字符串中最长不重复子串长度_case1(){
        assertEquals(5, s.lengthOfLongestSubstring("abcdabcdeeeeeee"));
    }

    @Test
    // https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
    void test_最小的k个数_case1(){
        int expect_result[] = {1,2,3,4};
        int numbers[] = {2,8,4,6,1,3,5,7};
        int result[] = s.getLeastNumbers(numbers, 4);

        for(int i = 0; i < result.length; i++){
            assertEquals(expect_result[i], result[i]);
        }
    }
}
