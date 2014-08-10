package lcoj.tree.build;

import java.util.Arrays;

import lcoj.common.TreeNode;

// Given preorder and inorder traversal of a tree,
// construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  // need to initialize static variable before each test cases for OJ
  private static int preIdx = -1;


  public TreeNode buildTree(int[] preorder, int[] inorder) {

    preIdx = -1;
    return helper(preorder, inorder);
  }


  private TreeNode helper(int[] preorder, int[] inorder) {

    if (preorder.length == 0 || inorder.length == 0) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[++preIdx]);
    // if (preIdx == preorder.length - 1) {
    // preIdx = -1;
    // }

    int i = 0;
    for ( ; i < inorder.length ; i++) {
      if (inorder[i] == root.val) {
        break;
      }
    }
    root.left = helper(preorder, Arrays.copyOfRange(inorder, 0, i));
    root.right = helper(preorder, Arrays.copyOfRange(inorder, i + 1, inorder.length));

    return root;
  }


  public static void main(String[] args) {

    int[] preorder = { 10, 5, 1, 7, 20, 30 };
    int[] inorder = { 1, 5, 7, 10, 20, 30 };

    ConstructBinaryTreeFromPreorderAndInorderTraversal cc = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
    System.out.println(cc.buildTree(preorder, inorder));

    int[] preorder2 = { 1, 2 };
    int[] inorder2 = { 2, 1 };
    System.out.println(cc.buildTree(preorder2, inorder2));
  }
}
