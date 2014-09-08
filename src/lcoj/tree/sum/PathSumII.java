package lcoj.tree.sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lcoj.common.TreeNode;

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// 
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]
public class PathSumII {

  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return rst;
    }

    LinkedList<Integer> curtPath = new LinkedList<Integer>();
    helper(root, sum, curtPath, rst);

    return rst;
  }


  private void helper(TreeNode root, int sum, LinkedList<Integer> curtPath, ArrayList<ArrayList<Integer>> rst) {

    if (root == null) {
      return;
    }

    if (sum - root.val == 0 && root.left == null && root.right == null) {
      // rst.add((ArrayList<Integer>) curtPath.clone());
      ArrayList<Integer> path = new ArrayList<Integer>();
      for (int i : curtPath) {
        path.add(i);
      }
      path.add(root.val);
      rst.add(path);
    }

    // coolest part
    curtPath.addLast(root.val);
    helper(root.left, sum - root.val, curtPath, rst);
    helper(root.right, sum - root.val, curtPath, rst);
    curtPath.removeLast();
  }


  // Pitfall: to judge a node is leaf, both its children should be null
  // can not add the list when we meet a null node because this will duplicate the result
  public List<List<Integer>> pathSum2(TreeNode root, int sum) {
      
      List<List<Integer>> rst = new ArrayList<List<Integer>>();
      if(root == null) {
          return rst;
      }
      
      List<Integer> tmpPath = new ArrayList<Integer>();
      dfsHelper(root, sum, rst, tmpPath);
      
      return rst;
  }
  
  void dfsHelper(TreeNode root, int sum, List<List<Integer>> rst, List<Integer> tmpPath) {
      if(root == null) {
          return;
      }
      
      if(root.val == sum && root.left == null && root.right == null) {
          tmpPath.add(root.val);
          rst.add(new ArrayList<Integer>(tmpPath));
          tmpPath.remove(tmpPath.size() - 1);
          return;
      }
      
      tmpPath.add(root.val);
      dfsHelper(root.left, sum - root.val, rst, tmpPath);
      dfsHelper(root.right, sum - root.val, rst, tmpPath);
      tmpPath.remove(tmpPath.size() - 1);
  }
  
  
  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(-2);
    TreeNode node2 = new TreeNode(-3);
    root.left = node1;
    root.right = node2;

    node1.left = new TreeNode(1);
    node1.right = new TreeNode(3);
    node2.left = new TreeNode(-2);

    node1.left.left = new TreeNode(-1);


    PathSumII pathSumII = new PathSumII();
    ArrayList<ArrayList<Integer>> rst = pathSumII.pathSum(root, 2);
    System.out.println(rst);

  }
}
