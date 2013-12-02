package lcoj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import lcoj.common.TreeNode;


public class BinaryTreePostorderTraversal {

  public static ArrayList<Integer> postorderTraversal(TreeNode root) {

    ArrayList<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    Set<TreeNode> visited = new HashSet<TreeNode>();
    stack.push(root);

    while (!stack.isEmpty()) {

      TreeNode currtNode = stack.peek();

      if (currtNode != null) {

        boolean flag = true;

        if (currtNode.right != null && !visited.contains(currtNode.right)) {
          flag = false;
          stack.push(currtNode.right);
        }

        if (currtNode.left != null && !visited.contains(currtNode.left)) {
          flag = false;
          stack.push(currtNode.left);
        }

        if (flag) {
          TreeNode cNode = stack.pop();
          list.add(cNode.val);
          visited.add(cNode);
        }

      } else {
        stack.pop();
      }

    }

    return list;
  }


  public static void main(String[] args) {

    System.out.println(postorderTraversal(null));
  }

}
