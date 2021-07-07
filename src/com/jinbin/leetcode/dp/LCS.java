package com.jinbin.leetcode.dp;

public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];

        if(text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        if(text1.charAt(0) == text2.charAt(0)){
            dp[0][0] = 1;
        }else {
            dp[0][0] = 0;
        }

        for(int j = 1; j < text2.length(); j++){
            if(text1.charAt(0) == text2.charAt(j)){
                dp[0][j] = 1;
            }else{
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i = 1; i < text1.length(); i++){
            if(text2.charAt(0) == text1.charAt(i)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int i = 1; i < text1.length(); i++){
            for(int j = 1; j < text2.length(); j++){
                if(text1.charAt(i) != text2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }else{
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp[text1.length()-1][text2.length()-1];
    }

    public static void main(String[] args){
        LCS lcs = new LCS();

        String s1 = "bsbininm";
        String s2 = "jmjkbkjkv";
        System.out.println(lcs.longestCommonSubsequence(s1, s2));
    }
}
