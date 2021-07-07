package com.jinbin.leetcode.sort;

public class firstBadVersion {
    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;

        while(last - first > 1){
            //int middle = (first + last) / 2;
            //todo Attention 避免超出范围
            int middle = first + (last - first) / 2;
            if(isBadVersion(middle)){
                last = middle;
            }else{
                first = middle;
            }
        }

        if(isBadVersion(first)){
            return first;
        }else if(isBadVersion(last)){
            return last;
        }

        return -1;
    }

    // 通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错
    public boolean isBadVersion(int n){
        return true;
    }
}
