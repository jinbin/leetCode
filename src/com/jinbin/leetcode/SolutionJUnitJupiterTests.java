package com.jinbin.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionJUnitJupiterTests {
    Solution s = new Solution();

    @ParameterizedTest
    @MethodSource("stringCompare")
    void test_字符串距离_复杂字符串比较(String s1, String s2, int expected){
        long startTime = System.currentTimeMillis();
        assertEquals(expected, s.minDistance_recursive(s1, s1.length(), s2, s2.length()));
        long endTime   = System.currentTimeMillis();
        long TotalTime = endTime - startTime;
        System.out.println("耗时: " + TotalTime + "毫秒");
    }

    @ParameterizedTest
    @MethodSource("stringCompare")
    void test_字符串距离1_相等字符串比较(String s1, String s2, int expected){
        long startTime = System.currentTimeMillis();
        assertEquals(expected, s.minDistance(s1, s2));
        long endTime   = System.currentTimeMillis();
        long TotalTime = endTime - startTime;
        System.out.println("耗时: " + TotalTime + "毫秒");
    }

    // It must be static
    // Arguments is a simple interface wrapping an array of objects
    private static Stream<Arguments> stringCompare(){

        return Stream.of(
                Arguments.of("array1", "expect_array1", 7),
                Arguments.of("Cyoungslime C漾史莱姆", "c.漾cyoungslime", 10),
                Arguments.of("array1", "array1_expect", 7),
                Arguments.of("", "abcd", 4),
                Arguments.of("", "", 0),
                Arguments.of("abcd", "abcd", 0)
        );
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
