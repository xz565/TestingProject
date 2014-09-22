package lcoj.tree.traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import lcoj.common.TreeNode;

public class BinaryTreeInorderTraversal {
	
	// extra set is used which is not necessary
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

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) {
            return rst;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode p = root;
        
        while(!stack.isEmpty() || p != null) {
        
        	if(p != null) {
        		stack.push(p);
        		p = p.left;
        	} else {
        		TreeNode top = stack.pop();
        		rst.add(top.val);
        		p = top.right;
        	}
        }
        
        return rst;
    }
}
