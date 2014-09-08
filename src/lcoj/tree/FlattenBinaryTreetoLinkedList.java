package lcoj.tree;

import lcoj.common.TreeNode;

//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6
public class FlattenBinaryTreetoLinkedList {

	// TLE
	public void flattenBad(TreeNode root) {

		while(root != null) {
			if(root.left != null) {
				TreeNode rightMost = getRightMost(root.left);
				rightMost.right = root.right;
				root.right = root.left;
			}
			root = root.right;
		}
	}

	private TreeNode getRightMost(TreeNode node) {
		while(node != null && node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	private TreeNode prev = null;
	
	public void flatten(TreeNode root) {
		
		TreeNode dummy = new TreeNode(0);
		dummy.right = root;
		prev = dummy;
		helper(root);
		
	}

	private void helper(TreeNode root) {
		if(root == null) return;

		prev.right = root;
		prev.left = null;
		prev = root;
		
		TreeNode temp = root.right;
		helper(root.left);
		helper(temp);
		
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(0);
		FlattenBinaryTreetoLinkedList flat = new FlattenBinaryTreetoLinkedList();
		flat.flatten(node);
	}
}
