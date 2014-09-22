package lcoj.tree;

import lcoj.common.TreeNode;

// Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
public class MinimumDepthofBinaryTree {

  // Guess: local max must not be the global min!
  public int minDepth(TreeNode root) {

    if (root == null) {
      return 0;
    } else if (root.left != null && root.right == null) {
      return minDepth(root.left) + 1;
    } else if (root.left == null && root.right != null) {
      return minDepth(root.right) + 1;
    } else if (root.left == null && root.right == null) {
      return 1;
    } else {
      return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }
  }
  
  // better one
  public int minDepth2(TreeNode root) {
	  if(root == null) {
		  return 0;
	  }
	  return getDepth(root);
  }
  private int getDepth(TreeNode root) {
	if(root == null) {
		return Integer.MAX_VALUE;
	}
	if(root.left == null && root.right == null) {
		return 1;
	} else {
		return Math.min(getDepth(root.left), getDepth(root.right));
	}
  }
}
