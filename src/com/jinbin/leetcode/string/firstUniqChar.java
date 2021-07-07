package com.jinbin.leetcode.string;

import java.util.HashMap;

public class firstUniqChar {
    public int firstUniqChar(String s) {
        // 原始类型 char，封装类 Character
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c) + 1);
            }else{
                hm.put(c, 1);
            }
        }

        for(int i = 0; i < s.length(); i++){
            if(hm.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}
