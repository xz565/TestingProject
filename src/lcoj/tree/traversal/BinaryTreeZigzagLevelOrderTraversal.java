package lcoj.tree.traversal;

import java.util.ArrayList;

import lcoj.common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if(root == null) return results;
    	
    	boolean zigZagFlag = false;
    	
    	ArrayList<TreeNode> curtLevel = new ArrayList<TreeNode>();
    	curtLevel.add(root);
    	
    	while(!curtLevel.isEmpty()) {
    		ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		// left -> right
    		for(TreeNode node : curtLevel) {
    			if(!zigZagFlag) {
    				result.add(node.val);
    			} else {
    				result.add(0, node.val);
    			}
    			
    			if(node.left != null) {
    				nextLevel.add(node.left);
    			}
    			if(node.right != null) {
    				nextLevel.add(node.right);
    			}
    		}
    		
    		curtLevel = nextLevel;
    		results.add(result);
    		zigZagFlag = !zigZagFlag;
    	}
    	
		return results ;
    }
}
