package com.jinbin.leetcode.dp;

public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length][matrix[0].length];
        sums[0][0] = matrix[0][0];

        for(int i = 1; i < matrix.length; i++){
            sums[i][0] = sums[i-1][0] + matrix[i][0];
        }

        for(int j = 1; j < matrix[0].length; j++){
            sums[0][j] = sums[0][j-1] + matrix[0][j];
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
            }
        }

        for(int i = 0; i < matrix.length; i++){
            System.out.println();
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(sums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int part1, part2, part3, part4 = 0;
        if(row2 >= 0 && col2 >= 0){
            part1 = sums[row2][col2];
        }else{
            part1 = 0;
        }

        if(row1 - 1 >= 0 && col2 >= 0){
            part2 = sums[row1-1][col2];
        }else{
            part2 = 0;
        }

        if(row2 >= 0 && col1-1 >= 0){
            part3 = sums[row2][col1-1];
        }else{
            part3 = 0;
        }

        if(row1-1 >= 0 && col1-1 >= 0){
            part4 = sums[row1-1][col1-1];
        }else{
            part4 = 0;
        }
        System.out.println("part1: " + part1);
        System.out.println("part2: " + part2);
        System.out.println("part3: " + part3);
        System.out.println("part4: " + part4);

        return part1 - part2 - (part3 - part4);
    }

    public static void main(String[] args){
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix nm = new NumMatrix(matrix);
        System.out.println(nm.sumRegion(2,1,4,3));
    }
}
