package lcoj.tree;

import lcoj.common.TreeNode;

public class SymmetricTree {

	// one simple solution is to iterate the tree in-order into an array
	// and then check whether this array is symmetric
	// but will take O(N) space, not good
	
	
	// recursive solution
	// Time: O(N) Space: O(1)
    public static boolean isSymmetric(TreeNode root) {
        
    	if(root == null) {
    		return true;
    	}
    	return helper(root.left, root.right);
    }

	private static boolean helper(TreeNode left, TreeNode right) {
		
		if(left == null && right == null) {
			return true;
		}
		
		if(left != null && right != null && left.val == right.val) {
			return helper(left.left, right.right) && helper(left.right, right.left);
		}

		return false;
	}
	
	// iterative solution is going through the tree level by level
	// and compare in each level
	// will do it in second iterative of Leetcode
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		isSymmetric(root);
	}
}
