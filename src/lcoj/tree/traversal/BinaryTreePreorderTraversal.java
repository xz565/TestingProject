package lcoj.tree.traversal;

import java.util.ArrayList;
import java.util.Stack;

import lcoj.common.TreeNode;


public class BinaryTreePreorderTraversal {

  // recursive, trivial
  public static ArrayList<Integer> preorderTraversal(TreeNode root) {

    ArrayList<Integer> list = new ArrayList<Integer>();
    helper(root, list);

    return list;
  }


  public static void helper(TreeNode root, ArrayList<Integer> list) {

    if (root == null) {
      return;
    }

    list.add(root.val);

    helper(root.left, list);
    helper(root.right, list);
  }


  // iteratively
  public static ArrayList<Integer> preorderTraversal2(TreeNode root) {

    ArrayList<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> nodes = new Stack<TreeNode>();

    nodes.add(root);

    while (!nodes.isEmpty()) {
      TreeNode currtNode = nodes.pop();
      if (currtNode != null) {
		list.add(currtNode.val);
		nodes.push(currtNode.right);
		nodes.push(currtNode.left);
      }

    }

    return list;
  }


  public static void main(String[] args) {

    // ArrayList<Integer> resultArrayList = new ArrayList<Integer>();

    System.out.println(preorderTraversal2(null));
  }
}
