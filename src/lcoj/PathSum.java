package lcoj;

import lcoj.common.TreeNode;


/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
 */
public class PathSum {

  public static boolean hasPathSum(TreeNode root, int sum) {
    
    if(root == null) {
      return false;
    }
    
    int leftSum = sum - root.val;
    
    if(leftSum == 0 && root.left == null && root.right == null) {
      return true;
    }
    
    boolean left = hasPathSum(root.left, leftSum);
    boolean right = hasPathSum(root.right, leftSum);

    return left || right;
  }
  
  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    System.out.println(hasPathSum(root, 1));
  }
}
