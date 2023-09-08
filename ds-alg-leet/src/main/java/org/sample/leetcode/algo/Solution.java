package org.sample.leetcode.algo;

class Solution {

  private TreeNode previous;
  private TreeNode inorderSuccessorNode;

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

    // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
    if (p.right != null) {

      TreeNode leftmost = p.right;

      while (leftmost.left != null) {
        leftmost = leftmost.left;
      }

      this.inorderSuccessorNode = leftmost;
    } else {

      // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
      this.inorderCase2(root, p);
    }

    return this.inorderSuccessorNode;
  }

  private void inorderCase2(TreeNode node, TreeNode p) {

    if (node == null) {
      return;
    }

    // Recurse on the left side
    this.inorderCase2(node.left, p);

    // Check if previous is the inorder predecessor of node
    if (this.previous == p && this.inorderSuccessorNode == null) {
      this.inorderSuccessorNode = node;
      return;
    }

    // Keeping previous up-to-date for further recursions
    this.previous = node;

    // Recurse on the right side
    this.inorderCase2(node.right, p);
  }
}