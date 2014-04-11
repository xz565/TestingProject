package lcoj.tree;

import java.util.ArrayList;

import lcoj.common.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
 * @author Xiaodong Zhang
 *
 */
public class BinaryTreeLevelOrderTraversalII {

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	
    	if(root == null) {
    		return results;
    	}
    	
    	ArrayList<TreeNode> curt = new ArrayList<TreeNode>();
    	curt.add(root);
    	
    	while(!curt.isEmpty()) {
    		ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    		ArrayList<Integer> rst = new ArrayList<Integer>();
    		
    		for(TreeNode node : curt) {
    			rst.add(node.val);
    			if(node.left != null) next.add(node.left);
    			if(node.right != null) next.add(node.right);
    		}
    		
    		results.add(0, rst);
    		curt = next;    	
    	}
		
    	return results;
    }
}
