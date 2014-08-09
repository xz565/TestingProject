package lcoj.tree.sum;

import lcoj.common.TreeNode;

// Given a binary tree, find the maximum path sum.
//
// The path may start and end at any node in the tree.
//
// For example:
// Given the below binary tree,
//
// 1
// / \
// 2 3
//
// Return 6.

// Does it contain negative nodes ? Yes
// And the root don't have to be in the path
//
// looks like an post order problem
public class BinaryTreeMaximumPathSum {


  // after the following three test cases failures, finally got the solution
  //
  // a node should have different behavior
  // when it serves as a node in the path AND as the root for the max path
  public int maxPathSum(TreeNode root) {

    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;

    helper(root, max);

    return max[0];
  }


  private int helper(TreeNode root, int[] max) {

    if (root == null) {
      return 0;
    }

    int leftSum = helper(root.left, max);
    int rightSum = helper(root.right, max);

    int pathMax = root.val;
    int rootMax = root.val;

    if (leftSum >= rightSum && leftSum > 0) {
      pathMax += leftSum;
    } else if (rightSum >= leftSum && rightSum > 0) {
      pathMax += rightSum;
    }

    if (leftSum > 0) {
      rootMax += leftSum;
    }
    if (rightSum > 0) {
      rootMax += rightSum;
    }

    if (rootMax > max[0]) {
      max[0] = rootMax;
    }

    return pathMax;
  }


  public static void main(String[] args) {

    // failed test cases
    // {2,-1} smart! need to consider left and right
    // {5,4,8,11,#,13,4,7,2,#,#,#,1}
    // {-3,-4,0,#,#,0,1,#,7,#,-3}

    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(-1);
    root.right = new TreeNode(3);

    BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
    System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
  }
}
