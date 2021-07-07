package com.jinbin.leetcode.dp;

import java.util.Arrays;

public class maxProfit {
    public int maxProfit(int[] prices) {
        //dp[i][0] 第i天没有股票的盈利
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] 第i天持有股票的盈利
        //dp[i][1] = max(dp[i-1][1], -prices[i])

        //处理异常情况
        if(prices.length <= 1){
            return 0;
        }

        int[][] dp = new int[prices.length+1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for(int i = 2; i < prices.length+1; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i-1]);
        }

        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));

        int profit = 0;
        for(int i = 1; i < prices.length+1; i++){
            if(dp[i][0] >= profit){
                profit = dp[i][0];
            }
        }

        return profit;
    }

    public static void main(String[] args){
        int prices[] = {1,2};

        maxProfit mp = new maxProfit();
        System.out.print(mp.maxProfit(prices));
    }
}
