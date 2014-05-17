package lcoj.tree.traversal;

import java.util.Arrays;

import lcoj.common.TreeNode;

// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  public TreeNode buildTree(int[] inorder, int[] postorder) {

    if (inorder.length == 0 || postorder.length == 0) {
      return null;
    }

    int rootVal = postorder[postorder.length - 1];
    TreeNode root = new TreeNode(rootVal);

    int rootIdxInorder = 0;
    for (int i = 0 ; i < inorder.length ; i++) {
      if (inorder[i] == rootVal) {
        rootIdxInorder = i;
        break;
      }
    }

    root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIdxInorder), Arrays.copyOfRange(postorder, 0, rootIdxInorder));
    root.right = buildTree(Arrays.copyOfRange(inorder, rootIdxInorder + 1, inorder.length), Arrays.copyOfRange(postorder, rootIdxInorder, postorder.length - 1));

    return root;
  }


  public static void main(String[] args) {

    int[] inorder = new int[] { 1, 3, 4, 5, 6, 10, 15, 20, 25 };
    int[] postorder = new int[] { 1, 4, 3, 6, 5, 15, 25, 20, 10 };
    ConstructBinaryTreeFromInorderAndPostorderTraversal con = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
    TreeNode root = con.buildTree(inorder, postorder);
    System.out.println(root);
  }
}
