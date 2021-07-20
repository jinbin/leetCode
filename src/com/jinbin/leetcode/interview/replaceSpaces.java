package com.jinbin.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class replaceSpaces {
    public String replaceSpaces(String S, int length) {
        char[] c_arr = S.toCharArray();
        List<Character> c_arr_new = new ArrayList<>();
        String result = "";
        for(int i = 0; i < length; i++){
            if(c_arr[i] == ' '){
                c_arr_new.add('%');
                c_arr_new.add('2');
                c_arr_new.add('0');

                result += "%20";
            }else{
                c_arr_new.add(c_arr[i]);

                result += c_arr[i];
            }
        }
        System.out.println(result);

        return result;
    }

    public String replaceSpaces1(String S, int length){
        StringBuilder builder = new StringBuilder();
        String result = "";
        for(int i = 0; i < length; i++){
            char c = S.charAt(i);
            if(c == ' '){
//                result += "%20";
                builder.append("%20");
            }else{
                builder.append(c);
//                result += c;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        replaceSpaces rs = new replaceSpaces();

        System.out.println(rs.replaceSpaces1("Mr John Smith    ", 13));
    }
}
