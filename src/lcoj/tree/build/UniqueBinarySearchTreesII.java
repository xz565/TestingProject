package lcoj.tree.build;

import java.util.ArrayList;
import java.util.List;

import lcoj.common.TreeNode;

// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//
//1         3     3      2      1
//\       /     /      / \      \
//3     2     1      1   3      2
///     /       \                 \
//2     1         2                 3
public class UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int n) {

    return helper(1, n);
  }


  private List<TreeNode> helper(int head, int tail) {

    List<TreeNode> rst = new ArrayList<TreeNode>();

    if (head > tail) {
      rst.add(null);
      return rst;
    }


    for (int i = head ; i <= tail ; i++) {

      List<TreeNode> leftNodes = helper(head, i - 1);
      List<TreeNode> rightNodes = helper(i + 1, tail);

      for (TreeNode left : leftNodes) {
        for (TreeNode right : rightNodes) {

          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          rst.add(root);
        }
      }
    }

    return rst;
  }


  public static void main(String[] args) {

    UniqueBinarySearchTreesII ubstII = new UniqueBinarySearchTreesII();
    System.out.println(ubstII.generateTrees(3));

  }
}
