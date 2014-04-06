package lcoj.tree;

import lcoj.common.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST
 * 
 * @author Xiaodong Zhang
 * 
 */
public class ConvertSortedArrayToBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] num) {

		return helper(num, 0, num.length - 1);
	}

	private static TreeNode helper(int[] num, int head, int tail) {
		
		if(head <= tail) {
			int middle = (head + tail) / 2;
			TreeNode root = new TreeNode(num[middle]);
			root.left = helper(num, head, middle - 1);
			root.right = helper(num, middle + 1, tail);
			return root;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6,7};
		TreeNode root = sortedArrayToBST(num);
		System.out.println(root);
	}
}
