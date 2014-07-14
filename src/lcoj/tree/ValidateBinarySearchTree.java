package lcoj.tree;

import lcoj.common.TreeNode;

// Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {

    return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }


  private boolean helper(TreeNode root, int maxValue, int minValue) {

    if (root == null) {
      return true;
    }

    if (root.val < maxValue && root.val > minValue) {
      return helper(root.left, root.val, minValue) && helper(root.right, maxValue, root.val);
    }

    return false;
  }
}
