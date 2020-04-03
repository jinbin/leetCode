package com.jinbin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        //char matrix[][] = {{'0','1','1','0','0','1','0','1','0','1'},{'0','0','1','0','1','0','1','0','1','0'},{'1','0','0','0','0','1','0','1','1','0'},{'0','1','1','1','1','1','1','0','1','0'},{'0','0','1','1','1','1','1','1','1','0'},{'1','1','0','1','0','1','1','1','1','0'},{'0','0','0','1','1','0','0','0','1','0'},{'1','1','0','1','1','0','0','1','1','1'},{'0','1','0','1','1','0','1','0','1','1'}};
        //int[] ints = new int[3];
        //char[][] matrix = {{'0','1','1','0','0','1','0','1','0','1'},{'0','0','1','0','1','0','1','0','1','0'},{'1','0','0','0','0','1','0','1','1','0'},{'0','1','1','1','1','1','1','0','1','0'},{'0','0','1','1','1','1','1','1','1','0'},{'1','1','0','1','0','1','1','1','1','0'},{'0','0','0','1','1','0','0','0','1','0'},{'1','1','0','1','1','0','0','1','1','1'},{'0','1','0','1','1','0','1','0','1','1'}};
        //System.out.println(s.maximalSquare(matrix));

        int[] nums = {1,2,3};
        ListNode head = s.makeNodes(nums);

        int[] nums1 = {1,4,5};
        int[] nums2 = {1,3,4};
        int[] nums3 = {2,6};
        ListNode[] array = {s.makeNodes(nums1), s.makeNodes(nums2), s.makeNodes(nums3)};

        //s.printNodes(s.mergeKLists(array));

        int[] nums4 = {4,5,6,7,0,1,2};
        int res = s.findPoint(nums4, 0, 6);
        System.out.println(res);

        //int[] heights = {1,2,3,4,5,6,7,8,9};
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("trap: ");
        System.out.println(s.trap(heights));

        String xxx = "abcdef";
        String[] xxx_arr = xxx.split("c");
        //System.out.println(xxx_arr);

        //s.checkInclusion("ab", "eidboaoo");

        System.out.println(Integer.parseInt("255"));

        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");

        ArrayList<String> b = new ArrayList<>();
        b.add("1"); b.add("2"); b.add("3");

        ArrayList<String> result = new ArrayList<>();
        a.addAll(b);
        System.out.println(a);

        int[] nums11 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums11));


    }
}

class Solution {
    // https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
    public int[] getLeastNumbers(int[] arr, int k) {
        for(int i = 0; i < k; i++){
            int curr = arr[i];
            for(int j = i - 1; j >= 0; j--){
                //Ni 与 Nj 依次进行比较
                if(curr >= arr[j]){
                    // Ni 插入此时位置，其他数字后移
                }else{
                    swap(arr, j, j + 1);
                }
            }
        }

        //前k个已经排好序了，后面开始依次比较
        for(int i = k; i < arr.length; i++){
            int curr = arr[i];
            // System.out.println("curr: " + curr);
            for(int j = k - 1; j >= 0; j--){
                if(curr < arr[j]){
                    if(j == k - 1){
                        swap(arr, j, i);
                    }else{
                        swap(arr, j, j + 1);
                        // System.out.println("swap: " + Arrays.toString(arr));
                    }
                }else{
                    break;
                }
            }
        }

        return Arrays.copyOfRange(arr, 0, 4);
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public ListNode makeNodes(int[] nums){
        ListNode head = null;
        ListNode end = null;
        for(int i = 0; i < nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            if(head == null){
                head = node;
                end = node;
            }else{
                end.next = node;
                //todo 又忘了end更新
                end = node;
            }
        }
        return head;
    }

    public void printNodes(ListNode head){
        System.out.println("这个链表的值为：");
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1012/
    public int lengthOfLongestSubstring(String s) {
        boolean flag = true;
        int max_len = 1;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            String curr = s.substring(i, i+1);
            for(int j = start; j < i; j++){
                if(s.substring(j, j+1).equals(curr)){
                    flag = false;
                    int len = i - start;
                    //println("j: " + j);
                    //println("len: " + len);
                    if(len > max_len){
                        max_len = len;
                    }
                    start = j + 1;
                    //println("start: " + start);
                }
            }
        }

        if(flag){
            return s.length();
        }else if (max_len > s.length() - start){
            return  max_len;
        } else {
            return (s.length() - start);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // 从当前点出发的面试 = 四周为1的点的面积总和
                // 当前点 grid[i][j]
                // grid[i-1][j], grid[i+1][j], grid[i][j-1], grid[i][j+1] 可能不存在
                // area(i,j) = 1 + area(i-1, j) + area(i+1, j) + area(i, j-1), area(i, j+1)
                int area = AreaOfIsland(grid, i, j, grid.length, grid[0].length);
                if(area > max_area){
                    max_area = area;
                }
            }
        }
        return max_area;
    }

    public int AreaOfIsland(int[][] grid, int i, int j, int max_i, int max_j){
        if(i < 0 || i >= max_i  || j < 0 || j >= max_j){
            return 0;
        }

//        if((i-1 < 0 || grid[i-1][j] == 0) && (i + 1 > max_i && grid[i+1][j] == 0) && (j -1 < 0 || grid[i][j-1] == 0) && (j+ 1 > max_j || grid[i][j+1] == 0)){
//            return 1;
//        }

        if(grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return 1 + AreaOfIsland(grid, i-1, j, max_i, max_j) + AreaOfIsland(grid, i+1, j, max_i, max_j) + AreaOfIsland(grid, i, j-1, max_i, max_j) + AreaOfIsland(grid, i, j+1, max_i, max_j);
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1042/
    public int maxProfit_bad(int[] prices) {
        //int[] memory = {};
        //todo 数组初始化
        List<Integer> memory = new ArrayList();
        for(int i = 0; i < prices.length; i++){
            for(int j=i+1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit < 0){
                    profit = 0;
                }

                memory.add(profit);
            }
        }

        int max = 0;
        for(int m = 0; m < memory.size(); m++){
            //todo 使用[]还是get
            if(memory.get(m) > max){
                max = memory.get(m);
            }
        }

        return max;
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1042/
    public int maxProfit(int[] prices) {
        int max = 0;
        int s_point = prices.length - 1;
        for(int i = s_point; i >= 0; i--){
            if(prices[s_point] < prices[i]){
                s_point = i;
            }else{
                int profit = prices[s_point] - prices[i];
                if(profit > max){
                    max = profit;
                }
            }
        }
        return max;
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1028/
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                int size = 0;
                int square = 0;
                while(size >= 0){
                    if(j+size >= matrix[0].length || i+size >= matrix.length){
                        size = -1;
                    }else{
                        // if(matrix[i][j+size] == '1' && matrix[i+size][j] == '1' && matrix[i+size][j+size] == '1')
                        if(ifSquare(i, j, size, matrix)){
                            square = (size + 1) * (size + 1);
                            size = size + 1;
                        }else{
                            size = -1;
                        }
                    }
                }
                if(square > max){
                    max = square;
                }
            }
        }
        return max;
    }

    public boolean ifSquare(int x, int y, int size, char[][] matrix){
        boolean flag = true;
        for(int i = 0; i < size + 1; i++){
            if(matrix[x+i][y+size] != '1'){
                flag = false;
            }
        }

        for(int j = 0; j < size + 1; j++){
            if(matrix[x+size][y+j] != '1'){
                flag = false;
            }
        }

        return flag;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode start = head;
        ListNode end = head.next;
        start.next = null;

        while(end != null){
            ListNode tmp = end.next;
            end.next = start;
            start = end;
            end = tmp;
        }

        return start;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode sum = null;
        ListNode end = null;
        boolean addone = false;

        //todo 容易考虑丢one 和 two 均为null，但有进位的情况
        while(one != null || two != null || addone){
            int val = 0;
            if(one != null & two != null){
                val = one.val + two.val;
            }else if(one != null){
                val = one.val;
            }else if(two != null){
                val = two.val;
            }

            if(addone){
                val = val + 1;
                addone = false;
            }
            if(val >= 10){
                val = val - 10;
                addone = true;
            }
            ListNode node = new ListNode(val);
            if(sum != null){
                end.next = node;
                //todo 遗漏了更新end值的操作
                end = node;
            }else{
                sum = node;
                end = sum;
            }
            if(one != null){
                one = one.next;
            }

            if(two != null){
                two = two.next;
            }
        }

        return sum;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //System.out.println("start");
        ListNode head = null;
        for(int i = 0; i < lists.length; i++){
            //System.out.println("打印head：");
            //printNodes(head);
            //System.out.println("Num: " + i);
            if(head == null){
                head = lists[i];
            }else{
                //合并 head 和 list[i]的有序链表
                ListNode pre = null;
                ListNode curr = head;
                ListNode next = curr.next;

                ListNode node = lists[i];

                //printNodes(head);
                //printNodes(node);

                while(node != null){
                    //System.out.println("node is: ");
                    //printNodes(node);
                    if(node.val <= curr.val){
                        if(pre == null){
                            ListNode tmp = node.next;
                            pre = node;
                            head = pre;
                            node.next = curr;
                            node = tmp;
                        }else{
                            ListNode tmp = node.next;
                            pre.next = node;
                            pre = node;
                            node.next = curr;
                            node = tmp;
                        }
                    }else{
                        if(next != null){
                            pre = curr;
                            curr = curr.next;
                            next = next.next;
                        }else{
                            curr.next = node;
                            node = null;
                        }
                    }
                }
            }
        }
        return head;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p_nodes = new ArrayList();
        ArrayList<TreeNode> q_nodes = new ArrayList();

        travel(root, p, p_nodes);
        travel(root, q, q_nodes);

        boolean flag = false;

        //todo 初始化要根据构造函数进行，之前少了0
        TreeNode ancestor = new TreeNode(0);

        for(int i = 0; i < p_nodes.size() && flag !=true; i++){
            int val = p_nodes.get(i).val;
            for(int j = 0; j < q_nodes.size(); j++){
                if(val == q_nodes.get(j).val){
                    ancestor = q_nodes.get(j);
                    //todo 缺乏break，导致第一次正确的结果被覆盖
                    flag = true;
                    break;
                }
            }
        }

        return ancestor;
    }

    public boolean travel(TreeNode root, TreeNode p, ArrayList<TreeNode> list){
        if(root == null){
            return false;
        }

        if(root.val == p.val){
            list.add(root);
            return true;
        }

        if(travel(root.left, p, list)){
            list.add(root);
            return true;
        }

        if(travel(root.right, p, list)){
            list.add(root);
            return true;
        }

        return false;
    }

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int point = findPoint(nums, 0, nums.length-1);
        //分成两部分进行二分查找
        //0, point-1
        //point, nums.length-1
        int res1 = search_half(nums, 0, point-1, target);
        int res2 = search_half(nums, point, nums.length-1, target);

        if(res1 == -1 && res2 == -1){
            return -1;
        }else if(res1 != -1){
            return res1;
        }else if(res2 != -1){
            return res2;
        }

        return -1;
    }

    public int search_half(int[] nums, int start, int end, int target){
        if(end < start){
            return -1;
        }
        int middle = start + (end - start)/2;
        if(target == nums[middle]){
            return middle;
        }
        if(target > nums[middle]){
            //在右半部分找
            return search_half(nums, middle+1, end, target);
        }else{
            //在左半部分找
            return search_half(nums, start, middle-1, target);
        }
    }

    public int findPoint(int[] nums, int start, int end){
        if(start == end){
            return start;
        }

        if(nums.length == 2){
            if(nums[0] > nums[1]){
                return end;
            }else{
                return start;
            }
        }

        int middle = start + (end - start)/2;
        System.out.println("start is : " + start);
        System.out.println("middle is : " + middle);

        if(middle != start && nums[start] > nums[middle-1]){
            //在左半部分查找
            System.out.println("get x");
            return findPoint(nums, start, middle-1);
        }else if(nums[middle] > nums[end]){
            //在右半部分找茬
            System.out.println("get y");
            return findPoint(nums, middle, end);
        }else{
            //middle就是分割点
            System.out.println("get z");
            return middle;
        }
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1036/
    public int findCircleNum(int[][] M) {
        int num_of_cycle = 0;
        for(int i = 0; i < M.length; i++){
            if(M[i][i] == 1){
                num_of_cycle = num_of_cycle + 1;
                searchCycle(M, i);
            }
        }
        return num_of_cycle;
    }

    public void searchCycle(int[][] M, int m){
        M[m][m] = 0;
        for(int i = 0; i < M.length; i++){
            if(M[m][i] == 1){
                M[m][i] = 0;
                M[i][m] = 0;
                searchCycle(M, i);
            }
        }
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1047/
    // 超出时间限制
    public int trap(int[] height) {
        int volume = 0;
        //求出max height
        int max_height = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > max_height){
                max_height = height[i];
            }
        }

        while(max_height > 0){
            int label = -1;
            for(int i = 0; i < height.length; i++){
                if(height[i] >= max_height){
                    if(label != -1){
                        //volume = volume + height[i] - height[label] -1;
                        volume = volume + i - label -1;
                    }
                    label = i;
                }
            }
            max_height = max_height - 1;
        }

        return volume;
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1047/
    // 满足要求
    public int trap_update(int[] height) {
        int volume = 0;
        //求出max height
        int max_height = 0;
        int max_height_index = -1;
        for(int i = 0; i < height.length; i++){
            if(height[i] > max_height){
                max_height = height[i];
                max_height_index = i;
            }
        }

        //从[0, max_height] 和 [max_height+1, height.length-1]两段
        int label = 0;
        for(int i = 0; i < max_height_index; i++){
            if(height[label] > height[i]){
                volume = volume + height[label] - height[i];
            }else{
                label = i;
            }
        }

        int label_1 = height.length - 1;
        for(int j = height.length - 1; j > max_height_index; j--){
            if(height[label_1] > height[j]){
                volume = volume + height[label_1] - height[j];
            }else{
                label_1 = j;
            }
        }

        return volume;
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1013/
    public String simplifyPath(String path) {
        ArrayList<String> p = new ArrayList();
        for(String s: path.split("/")){
            if(s.equals("")){
                continue;
            }else if(s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(p.size() != 0){
                    p.remove(p.size() - 1);
                }
            }else {
                p.add(s);
            }
        }
        if(p.size() == 0){
            return "/";
        }

        String out = "";
        for(int i = 0; i < p.size(); i++){
            out = out + "/" + p.get(i);
        }
        return out;
    }

    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0; i < s2.length(); i++){
            //如果s2当前的字符在s1出现
            if(if_in(s2.substring(i, i+1), s1)){
                System.out.println("sub start: ");
                System.out.println(s2.substring(i, i+1));
                boolean pre = true;
                System.out.println(s1.length());
                for(int j=1; j < s1.length(); j++) {
                    //第二个
                    if (if_in(s2.substring(i + j, i + j + 1), s1) == false || i + j + 1 > s2.length()) {
                        pre = false;
                        System.out.println(s2.substring(i + j, i + j + 1));
                        break;
                    }
                }
                if(pre){
                    return true;
                }
            }else{
                continue;
            }
        }
        return false;
    }

    public boolean if_in(String c, String s){
        for(int i = 0; i < s.length(); i++){
            String c_in_s = s.substring(i, i+1);
            if(c.equals(c_in_s)){
                return true;
            }
        }
        return false;
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1044/
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList();
        result = split(s, 4);
        return result;
    }

    public ArrayList<String> split(String s, int num){
        ArrayList<String> result = new ArrayList();
        if(num == 1){
            if(isNum(s)){
                result.add(s);
            }
            return result;
        }
        for(int i = 1; i < s.length() && i < 4;i++){
            String s1 = s.substring(0,i);
            if(isNum(s1) == false){
                continue;
            }
            //result.add(s);
            ArrayList<String> part_result = split(s.substring(i,s.length()), num - 1);
            for(int j = 0; j < part_result.size(); j++){
                result.add(s1 + "." + part_result.get(j));
            }
        }
        return result;
    }

    public boolean isNum(String s){
        if(s.length() > 3 || s.length() == 0){
            return false;
        }
        if(s.length() > 1 && s.substring(0,1).equals("0")){
            return false;
        }
        if(Integer.parseInt(s) > 255){
            return false;
        }
        return true;
    }

    // https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1029/
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = -1000000;

        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public int find_matrix_num(int[][] matrix){
        int total_num = 0;
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == 1){
                    total_num = total_num + 1;
//                    System.out.println("total_num: " + total_num);
//                    System.out.println("z: " + String.valueOf(matrix.length - 1 - i));
                    for(int z = 1; z <= matrix.length - 1 - i; z++){
//                        System.out.println("z: " + z);
                        if(is_matrix(matrix, i, j, z)){
                            total_num = total_num + 1;
                        }else{
                            break;
                        }
                    }
                }else{
                    continue;
                }
            }
        }
        return total_num;
    }

    // 判断是否存在matrix
    public boolean is_matrix(int[][] matrix, int i, int j, int len){
//        System.out.println("len: " + len);
        if(i + len > matrix[0].length - 1){
            return false;
        }

        if(j + len > matrix.length - 1){
            return false;
        }

        for(int x = i; x < i+len+1; x++){
            // 写错成 j < y + len + 1;
            for(int y = j; y < j + len + 1; y++){
//                System.out.println("x, y" + x + " " + y );
                if(matrix[x][y]!=1){
                    return false;
                }
            }
        }

        return true;
    }

    public int minDistance_recursive(String s1, int len1, String s2, int len2){

        if(len1 == 0){
            return len2;
        }

        if(len2 == 0){
            return len1;
        }

        char c1 = s1.charAt(len1 - 1);
        char c2 = s2.charAt(len2 - 1);

        if(c1 == c2){
            return minDistance_recursive(s1, len1 -1, s2, len2 - 1);
        }

        int temp_len1 = minDistance_recursive(s1, len1 - 1, s2, len2);
        int temp_len2 = minDistance_recursive(s1, len1, s2, len2 - 1);
        int temp_len3 = minDistance_recursive(s1, len1 - 1, s2, len2 - 1);

        return Math.min(temp_len3, Math.min(temp_len1, temp_len2)) + 1;
    }

    public int minDistance(String s1, String s2){
        if(s1.length() == 0){
            return s2.length();
        }

        if(s2.length() == 0){
            return s1.length();
        }

        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i < s1.length() + 1; i++){
            for(int j = 0;j < s2.length() + 1; j++){
                matrix[i][j] = -1;
            }
        }

        //matrix[0][0] = 0;

        // forget to add 1
        for(int j = 0; j < s2.length() + 1; j++){
            matrix[0][j] = j;
        }

        for(int i = 0; i < s1.length() + 1; i++){
            matrix[i][0] = i;
        }

        for(int i = 0; i < s1.length() + 1; i++){
            for(int j = 0; j < s2.length() + 1; j++){
                // 若未计算，则计算
                if(matrix[i][j] < 0){
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
                    if(s1.charAt(i-1) != s2.charAt(j-1)){
                        matrix[i][j] = matrix[i][j] + 1;
                    }
                }
            }
        }

//        for(int j = 0; j < s2.length(); j++){
//            System.out.print(" " + s2.charAt(j));
//        }
//
//        for(int i = 0; i < s1.length(); i++){
//            System.out.println("");
//            System.out.print(s1.charAt(i) + " ");
//            for(int j = 0; j < s2.length(); j++){
//                System.out.print(matrix[i][j] + " ");
//            }
//        }

        return matrix[s1.length()][s2.length()];
    }

    public int unfinished_distance(String s1, String s2){
        // 第一个字母匹配上
        String first = s1.substring(0,1);
        int len1 = 0;
        int len2 = 0;
        int min_len1 = 1000000;
        for(int i = 0; i < s2.length(); i++){
            if(s2.substring(i,i+1).endsWith(first)){
                if(s1.length() == 1){
                    len1 = s2.length() - 1;
                }else {
                    // 匹配上，距离 = i + 之后匹配的距离
                    len1 = unfinished_distance(s1.substring(1, s1.length()), s2.substring(i, s2.length())) + i;
                }
                if(len1 < min_len1){
                    min_len1 = len1;
                }
            }
        }

        // 第一个字母没有匹配上
        len2 = 1 + unfinished_distance(s1.substring(1, s1.length()), s2);

        if(len1 < len2){
            return len1;
        }else{
            return len2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class MinStack {

    private ArrayList<Integer> array;

    /** initialize your data structure here. */
    public MinStack() {
        array = new ArrayList();
    }

    public void push(int x) {
        // this.array.push(x);
        // System.out.println(x);
        array.add(x);
        System.out.println(array);
    }

    public void pop() {
        //this.array.delete(array.length - 1);
        array.remove(array.size() - 1);
    }

    public int top() {
        // return this.array[array.length - 1];
        // System.out.println(array);
        return array.get(array.size() - 1);
    }

    public int getMin() {
        int min = array.get(0);
        // length -> size()
        for(int i = 1; i < array.size(); i++){
            if(array.get(i) < min){
                min = array.get(i);
            }
        }
        return min;
    }
}