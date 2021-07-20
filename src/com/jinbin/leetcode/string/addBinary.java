package com.jinbin.leetcode.string;

public class addBinary {
    public String addBinary(String a, String b){
        long a_i = Integer. parseInt(a);
        long b_i = Integer. parseInt(b);

        System.out.println(a_i);
        System.out.println(b_i);

        long sum = a_i + b_i;
        //String sum = Integer.toString(a_i + b_i);
        System.out.println("sum is " + sum);

        boolean carry = false;
        long count = 1;
        long result = 0;
        while(sum != 0){
            long left = sum % 10;
            sum = sum / 10;
            System.out.println(result);
            if(left == 2){
                if(carry){
                    result = result + 1 * count;
                }
                carry = true;
            }else{
                if(carry){
                    if(left == 0){
                        result = result + 1 * count;
                        carry = false;
                    }else{ // left == 1
                        carry = true;
                    }
                }else{
                    result = result + left * count;
                    carry = false;
                }
            }
            count = count * 10;
        }

        if(carry){
            result = result + 1 * count;
        }

        return Long.toString(result);
    }

    public String addBinary1(String a, String b) {
        while(a.length() < b.length()){
            a = "0" + a;
        }
        while(a.length() > b.length()){
            b = "0" + b;
        }

        String result = "";
        boolean carry = false;

        for(int i = 0; i < a.length(); i++){
            int index = a.length() - 1 - i;
            if(a.charAt(index) == '0'){
                if(b.charAt(index) == '0'){
                    result = carry ? '1' + result : '0' + result;
                    carry = false;
                }else if(b.charAt(index) == '1'){
                    if(carry){
                        result = '0' + result;
                        carry = true;
                    }else{
                        result = '1' + result;
                        carry = false;
                    }
                }
            }
            if(a.charAt(index) == '1'){
                if(b.charAt(index) == '0'){
                    if(carry){
                        result = '0' + result;
                        carry = true;
                    }else{
                        result = '1' + result;
                        carry = false;
                    }
                }else if(b.charAt(index) == '1'){
                    result = carry ? '1' + result : '0' + result;
                    carry = true;
                }
            }
        }

        if(carry){
            result = '1' + result;
        }
        return result;
    }

    public static void main(String[] args){
        addBinary ab = new addBinary();
        System.out.println(ab.addBinary1("1010", "1011"));
    }
}
