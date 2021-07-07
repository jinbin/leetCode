package com.jinbin.leetcode.string;

public class isPalindrome {
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            System.out.println(c);
            if(!Character.isLetterOrDigit(c)){
                s = s.replace(c+"", "");
            }
        }

        System.out.println(s);

        for(int i = 0; i < s.length() / 2; i++){
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(s.length() - 1 -i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        isPalindrome ip = new isPalindrome();

        System.out.println(ip.isPalindrome("Marge, let's \"[went].\" I await {news} telegram."));
    }
}
