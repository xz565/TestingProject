package lcoj.tree;

import lcoj.common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author Xiaodong Zhang
 * 
 */
public class BalancedBinaryTree {
    
	// a bottom to top solution
	// in each level, we need to return the balance info, as well as the level count
	// so made an new Type to hold the return result
	
	// can simple return -1 to mark as false!!!!!!
	public boolean isBalanced(TreeNode root) {
        
		Result r = helper(root);
		return r.balanced;
		
	}

	private Result helper(TreeNode root) {
		
		Result result = new Result();
		if(root == null) {
			result.level = 1;
			result.balanced = true;
			return result;
		}
		
		Result leftResult = helper(root.left);
		Result rightResult = helper(root.right);
		
		if(leftResult.balanced && rightResult.balanced && Math.abs(leftResult.level - rightResult.level) <= 1){
			result.balanced = true;
			result.level = Math.max(leftResult.level, rightResult.level) + 1;
		} else {
			result.balanced = false;
		}
		
		return result;
	}
	
	class Result {
		int level;
		boolean balanced;
	}

}

