package lcoj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import lcoj.common.TreeNode;

public class BinaryTreeInorderTraversal {
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Set<TreeNode> visited = new HashSet<TreeNode>();
    	
    	if(root != null) {
    		stack.push(root);
    		visited.add(root);
    	}
    	
    	while(!stack.isEmpty()) {
    		
    		boolean flag = true;
    		
    		TreeNode currtNode = stack.pop();
    		
    		if(currtNode.right != null && !visited.contains(currtNode.right)) {
    			stack.push(currtNode.right);
    			flag = false;
    			visited.add(currtNode.right);
    		}
    		
    		stack.push(currtNode);
    		
    		if(currtNode.left != null && !visited.contains(currtNode.left)) {
    			stack.push(currtNode.left);
    			flag = false;
    			visited.add(currtNode.left);
    		}
    		
    		if(flag) {
    			list.add(stack.pop().val);
    		}
    	}
    	
    	return list;
    }

}
