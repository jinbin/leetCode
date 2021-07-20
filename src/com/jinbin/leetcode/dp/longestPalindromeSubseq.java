package com.jinbin.leetcode.dp;

public class longestPalindromeSubseq {
    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }

        return get_dp(s, 0, s.length()-1);
    }

    public int get_dp(String s, int i, int j){
        if(i > j || i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] == 0){
            // 需要进行dp[i][j]计算
            if(s.charAt(i) == s.charAt(j)){
                return get_dp(s, i+1, j-1) + 2;
            }else{
                return Math.max(get_dp(s, i+1, j), get_dp(s, i, j-1));
            }
        }else{
            return dp[i][j];
        }
    }

    public int longestPalindromeSubseq1(String s){
        dp = new int[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }

        for(int i = s.length()-1; i > 0; i--){
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){

                }
            }
        }

        return 0;
    }


    public static void main(String[] args){
        String s = "cbbd";
        longestPalindromeSubseq lps = new longestPalindromeSubseq();
        System.out.println(lps.longestPalindromeSubseq(s));
    }
}
