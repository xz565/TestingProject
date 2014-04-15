package lcoj.tree;

import lcoj.common.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

	if (p == null && q == null) {
	    return true;
	}

	if (p != null && q != null && p.val == q.val) {
	    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	return false;
    }

    public static void main(String[] args) {
	System.out.println(null == null);
    }
}
