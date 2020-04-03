package com.jinbin.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class BasicsJUnitJupiterTests {
    Basics b = new Basics();

    @ParameterizedTest
    @MethodSource("bubbleSortParameters")
    void test_bubbleSort(int[] nums, int[] expect_nums){
        int[] result = b.bubblesort(nums);
        for(int i = 0; i < expect_nums.length; i++){
            assertEquals(result[i], expect_nums[i]);
        }
    }

    // It must be static
    // Arguments is a simple interface wrapping an array of objects
    private static Stream<Arguments> bubbleSortParameters(){
        int[] array1 = {0};
        int[] expect_array1 = {0};
        int[] empty_array = {};
        int[] expect_empty_array = {};
        int[] array11 = {6,53,3,7,4,-1,33,12,3,9,10};
        int[] expect_array11 = {-1, 3, 3, 4, 6, 7, 9, 10, 12, 33, 53};
        int[] array12 = {1,2,3,4,5,6,7,12,11,10,9,8};
        int[] expect_array12 = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] array_x1 = {10,9,8,7,6,5,4,3,2,1};
        int[] expect_array_x1 = {1,2,3,4,5,6,7,8,9,10};

        return Stream.of(
                Arguments.of(array1, expect_array1),
                Arguments.of(empty_array, expect_empty_array),
                Arguments.of(array11, expect_array11),
                Arguments.of(array12, expect_array12),
                Arguments.of(array_x1, expect_array_x1)
        );
    }

    @ParameterizedTest
    @MethodSource("selectionSortParameters")
    void test_selectionSortParameterized(int[] nums, int[] expect_nums){
        int[] result = b.bubblesort(nums);
        for(int i = 0; i < expect_nums.length; i++){
            assertEquals(result[i], expect_nums[i]);
        }
    }

    //It must be static
    private static Stream<Arguments> selectionSortParameters() {
        int[] array1 = {0};
        int[] expect_array1 = {0};
        int[] empty_array = {};
        int[] expect_empty_array = {};
        int[] array11 = {6,53,3,7,4,-1,33,12,3,9,10};
        int[] expect_array11 = {-1, 3, 3, 4, 6, 7, 9, 10, 12, 33, 53};

        return Stream.of(
                Arguments.of(array1, expect_array1),
                Arguments.of(empty_array, expect_empty_array),
                Arguments.of(array11, expect_array11)
        );
    }

    @ParameterizedTest
    @MethodSource("bubbleSortParameters")
    void test_insertionSortParameterized(int[] nums, int[] expect_nums){
        int[] result = b.insertionSort(nums);
        for(int i = 0; i < expect_nums.length; i++){
            assertEquals(result[i], expect_nums[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("bubbleSortParameters")
    void test_shellSortParameterized(int[] nums, int[] expect_nums){
        int[] result = b.shellSort(nums);
        System.out.println(Arrays.toString(result));
        for(int i = 0; i < expect_nums.length; i++){
            assertEquals(result[i], expect_nums[i]);
        }
    }
}
