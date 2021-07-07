package com.jinbin.test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    //给你一个字符串 s，找到 s 中最长的回文子串。
    public String longestPalindrome(String s) {
        // 输入：s = "babad"
        // 输出："bab"
        // 解释："aba" 同样是符合题意的答案。

        // p(i,j) = true if p(i+1, j-1) = true ^ s[i] == s[j]

        String s1 = "abdcd";
        int len = s1.length();

        System.out.println(len);

        char[] chars = s1.toCharArray();

        boolean[][] matrix = new boolean[len][len];

        System.out.println(matrix.length);

        return "s";
    }

    public void makeData(){
        HashSet<String> hs = new HashSet<>();
        JSONArray ja = new JSONArray();
        try {
            BufferedReader in = new BufferedReader(new FileReader("/Users/jinbin/Code/leetCode/src/com/jinbin/test/userIds.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                if(hs.add(str)){
                    JSONObject jo = new JSONObject();
                    jo.put("itemId", "3555506819");
                    jo.put("shopId", "832749");
                    jo.put("buyerId", str);
                    jo.put("shopUID", "w832749");
                    jo.put("payTime", "2021-05-30 15:59:45");

                    ja.put(jo);
                };
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        JSONObject data = new JSONObject();
        data.put("datas", ja);
        System.out.println(data);
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
            System.out.println(single);
        }
        return single;
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else{
            String v = String.valueOf(x);
            System.out.println(v.length() / 2);
            for(int i = 0; i < v.length() / 2; i++){
                int j = v.length() - 1 - i;
                if(v.charAt(i) != v.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }

    public int lengthOfLastWord(String s) {
        String[] s_list = s.split(" ");
        return s_list[s_list.length - 1].length();
    }

    public int peakIndexInMountainArray(int[] arr) {
        int pre = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > pre){
                pre = arr[i];
                continue;
            }else{
                return i-1;
            }
        }
        return -1;
    }

    public int trailingZeroes(int n) {
        int i = 1;
        int sum = 0;
        while(n >= Math.pow(5, i)){
            sum = sum + (n / (int) Math.pow(5, i));
            i++;
        }
        return sum;
    }

    public void xx(){
        HashMap<Character, Integer> hm = new HashMap<>();
        String[] s = {"abc", "bdc", "adem", "mzd"};
        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < s[i].length(); j++){
                char curr = s[i].charAt(j);
                if(hm.get(curr) == null){
                    hm.put(curr, 1);
                }else{
                    hm.put(curr, hm.get(curr) + 1);
                }
            }
        }
        for(char c : hm.keySet()){
            System.out.println(c + ":" + hm.get(c));
        }
    }

    public static void main(String[] args){
//        Solution s = new Solution();
//        System.out.println(s.lengthOfLastWord("Hello World11111"));
//
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(true & false);
//        System.out.println(true && false);

//        int[] arr = {3,4,5,1};
//        Solution s = new Solution();
//        int peak = s.peakIndexInMountainArray(arr);
//        System.out.println(peak);

        Solution s = new Solution();
//        s.trailingZeroes(10);
        s.xx();
    }
}
