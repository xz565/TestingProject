package lcoj.tree.sum;

import lcoj.common.TreeNode;

// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
// 
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
// 
// Find the total sum of all root-to-leaf numbers.
// 
// For example,
// 
//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// 
// Return the sum = 12 + 13 = 25.
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        
    	int[] sum = new int[1];
    	
    	helper(root, 0,  sum);
    	
    	return sum[0];
    }

	private void helper(TreeNode root, int parentVal, int[] sum) {
		
		if(root == null) return;
		
		int curtVal = parentVal*10 + root.val;
		if(root.left == null && root.right == null) {
			sum[0] += curtVal;
			return;
		}
		
		helper(root.left, curtVal, sum);
		helper(root.right, curtVal, sum);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
		System.out.println(sumRootToLeafNumbers.sumNumbers(root));
	}
}
