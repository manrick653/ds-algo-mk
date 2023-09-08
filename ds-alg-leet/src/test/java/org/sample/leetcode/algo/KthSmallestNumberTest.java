package org.sample.leetcode.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KthSmallestNumberTest {
  //Input: root = [3,1,4,null,2], k = 1
  @Test
  void whenTreeNodeTest(){
    TreeNode two = new TreeNode(null,null,2);

    TreeNode left = new TreeNode(null,two,1);
    TreeNode right = new TreeNode(null,null,4);

    TreeNode root = new TreeNode(left,right,3);

    KthSmallestNumber kthSmallestNumber = new KthSmallestNumber();
    System.out.println(kthSmallestNumber.kthSmallest(root,1));
  }

}