package lcoj.tree;

import lcoj.common.TreeNode;

// Two elements of a binary search tree (BST) are swapped by mistake.
//
// Recover the tree without changing its structure.
//
// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
public class RecoverBinarySearchTree {

	TreeNode prev = null;
	TreeNode first = null;
	TreeNode second = null;

	// in place
	// strictly speaking, this is not O(N) solution,
	// it uses at least O(lgN) space in system stack, and worse case can be O(N)
	public void recoverTree(TreeNode root) {

		TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
		dummy.right = root;
		prev = dummy;
		inOrder(root);

		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	// in order
	private void inOrder(TreeNode root) {

		if (root != null) {
			inOrder(root.left);
			if (root.val < prev.val) {
				if (first == null) {
					first = prev;
					second = root;
				} else {
					second = root;
					return; // will TLE if not return here
				}
			}
			prev = root;
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		// root.right = new TreeNode(1);
		System.out.println(root);

		RecoverBinarySearchTree recover = new RecoverBinarySearchTree();
		recover.recoverTree(root);
		System.out.println(root);
	}
}
