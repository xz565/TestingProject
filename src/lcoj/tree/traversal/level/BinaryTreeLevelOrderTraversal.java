package lcoj.tree.traversal.level;

import java.util.ArrayList;

import lcoj.common.TreeNode;


/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author Xiaodong Zhang
 *
 */
public class BinaryTreeLevelOrderTraversal {

	// easy
	// one time AC
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
   
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
    		
    		results.add(rst);
    		curt = next;    	
    	}
    	
		return results;
    }
    
    // there is another recurisive solutions
    // use a helper function, pass in depth info and results, the add the the corresponding place
    // for II, use Collection.reverse... not sure the time complexity of the Collection.reverse
}
