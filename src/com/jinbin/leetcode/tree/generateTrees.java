package com.jinbin.leetcode.tree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class generateTrees {

    public TreeNode generateTree(int i, int j, TreeNode t) {
        for(int v = i; v <= j; v++){
            t.val = v;

            if(v == i){
                t.left = null;
            }else{
                TreeNode t1 = new TreeNode();
                t.left = t1;
                generateTree(i, v-1, t1);
            }

            if(v == j){
                t.right = null;
            }else{
                TreeNode t2 = new TreeNode();
                t.right = t2;
                generateTree(v+1, j, t2);
            }
        }

        return t;
    }

    public static void main(String[] args){
        System.out.print("ok");
    }
}
