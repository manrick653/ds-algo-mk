package org.sample.leetcode.algo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KthSmallestNumber {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */

    Set<Integer> ele = new HashSet<>();
    public int kthSmallest(TreeNode root, int k) {

      Queue<Integer> heap = new PriorityQueue<>((n1,n2)-> n2-n1);//max heap
      //heap.add(root.val);
      dfs(root);
      System.out.println(ele);
      for(int n : ele){
        heap.add(n);
        if(heap.size() > k){
          heap.poll();
        }
      }
      return heap.poll();

    }
    void dfs(TreeNode root){

      if(root == null){
        return ;
      }
      dfs(root.left);
      ele.add(root.val);
      dfs(root.right);
      ele.add(root.val);
    }

}
