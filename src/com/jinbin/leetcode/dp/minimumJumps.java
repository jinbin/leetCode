package com.jinbin.leetcode.dp;

public class minimumJumps {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        //f(x) = f(x-a) + 1 (x-a不是forbidden)
        //f(x) = f(x+b) + 1 (x+b不是forbidden) 且 f(x) != f(x+2b) + 2 => f(x+2b) != f(x) - 2
        //f(x) = min(f(x-a) + 1, f(x+b) + 1) 如果 x-a不是forbidden && x+b不是forbidden
        //
        //首先，f(a) = 1, f(2a) = 2, f(3a) = 3...
        //然后，f(a-b) = 2, f(2a-b) = 2, f(3a-b) = 4...
        //那么，f(x) = 以上值 + 1（向前跳了一步a，因为不能向后跳了）
        //其他值就是无法达到的区域
        //f(x) = f(x-a) + 1;

        int max = -1;
        for(int i = 0; i < forbidden.length; i++){
            if(forbidden[i] > max){
                max = forbidden[i];
            }
        }

        //int[] nums = new int[Math.max(max, x)+1];
        int[] nums = new int[Math.max(max, x)+1];
        for(int i = 0; i < nums.length; i++){
            // 初始值设置为-2
            nums[i] = -2;
        }

        for(int i = 0; i < forbidden.length; i++){
            // -1表示此位置不可达
            nums[forbidden[i]] = -1;
        }

        //System.out.println(Arrays.toString(nums));

        boolean flag = true;
        for(int i = 0; i < nums.length; i = i+a){
            if(flag && nums[i] != -1){
//                System.out.println("xxxx: " + i);
                nums[i] = i/a;
            }else{
                nums[i] = -1;
                flag = false;
            }
            if(flag && i-b >= 0 && nums[i-b] == -2){
                nums[i-b] = i/a+1;
            }
        }

        //System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != -2){
                continue;
            }

            if(i-a >= 0 && nums[i-a] != -1){
                nums[i] = nums[i-a] + 1;
            }else{
                nums[i] = -1;
            }
        }

        //System.out.println(Arrays.toString(nums));

        return nums[x];
    }

    public static void main(String[] args){
//        int[] forbidden = {18,13,3,9,8,14};
        minimumJumps mj = new minimumJumps();
//        System.out.println(mj.minimumJumps(forbidden, 3, 8, 6));

//        int[] f0 = {14,4,18,1,15};
//        System.out.println(mj.minimumJumps(f0, 3, 15, 9));

//        int[] f1 = {1,6,2,14,5,17,4};
//        System.out.println(mj.minimumJumps(f1, 16, 9, 7));
//
//        int[] f2 = {8,3,16,6,12,20};
//        System.out.println(mj.minimumJumps(f1, 15, 13, 11));

        int[] f3 = {128,178,147,165,63,11,150,20,158,144,136};
        System.out.println(mj.minimumJumps(f3, 61, 170, 135));
    }
}
