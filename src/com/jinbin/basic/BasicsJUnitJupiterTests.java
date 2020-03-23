package com.jinbin.basic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class BasicsJUnitJupiterTests {
    Basics b = new Basics();

    @Test
    void test_bubblesort(){
        int[] nums = {6,53,3,7,4,-1,33,12,3,9,10};
        int[] expect = {-1, 3, 3, 4, 6, 7, 9, 10, 12, 33, 53};
        int[] result = b.bubblesort(nums);
        System.out.println(Arrays.toString(result));
        for(int i = 0; i < expect.length; i++){
            assertEquals(expect[i], result[i]);
        }
    }

    @Test
    void test_bubblesort_blank(){
        int[] nums = {};
        int[] result = b.bubblesort(nums);
        System.out.println(Arrays.toString(result));
        assertEquals(0, result.length);
    }

    @Test
    void test_bubblesort_single(){
        int[] nums = {1};
        int[] result = b.bubblesort(nums);
        System.out.println(Arrays.toString(result));
        assertEquals(1, result.length);
    }

    @Test
    void test_selectionSort(){
        int[] nums = {6,53,3,7,4,-1,33,12,3,9,10};
        int[] expect = {-1, 3, 3, 4, 6, 7, 9, 10, 12, 33, 53};
        int[] result = b.selectionSort(nums);
        System.out.println(Arrays.toString(result));
        for(int i = 0; i < expect.length; i++){
            assertEquals(expect[i], result[i]);
        }
    }
}
