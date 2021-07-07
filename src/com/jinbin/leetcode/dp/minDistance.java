package com.jinbin.leetcode.dp;

public class minDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        if(word1.length() == 0){
            return word2.length();
        }else if(word2.length() == 0){
            return word1.length();
        }

        if(word1.charAt(0) == word2.charAt(0)){
            dp[0][0] = 0;
        }else{
            dp[0][0] = 1;
        }

        for(int j = 1; j < word2.length(); j++){
            if(word2.charAt(j) == word1.charAt(0)){
                dp[0][j] = j;
            }else{
                dp[0][j] = dp[0][j-1] + 1;
            }
        }

        for(int i = 1; i < word1.length(); i++){
            if(word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = i;
            }else{
                dp[i][0] = dp[i-1][0] + 1;
            }
        }

        for(int i = 1; i < word1.length(); i++){
            for(int j = 1; j < word2.length(); j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, dp[i-1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j-1] + 1, dp[i][j]);
                }
            }
        }

        return dp[word1.length()-1][word2.length()-1];
    }

    public static void main(String[] args){
        minDistance md = new minDistance();

        String s1 = "a1gd";
        String s2 = "ad";
        System.out.println(md.minDistance(s1, s2));
    }
}
