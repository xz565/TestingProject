package lcoj.tree.uniquebst;

import java.util.HashMap;
import java.util.Map;

// Given n, how many structurally unique 
// BST's (binary search trees) that store values 1...n?
//
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class UniqueBinarySearchTrees {
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numTrees(int n) {

    	if(n  == 0 || n == 1)
    		return 1;
    	
    	int sum = 0;
    	for(int i = 1; i <= n; i++) {
    		//int left = numTrees(i - 1);
    		int left = map.get(i-1) == null ? numTrees(i-1) : map.get(i-1);
    		// int right = numTrees(n - i);
    		int right = map.get(n-i) == null ? numTrees(n-i) : map.get(n-i);
    		sum += left * right;
    		
    		
    	}
    	map.put(n, sum);
    	return sum;
    }
    
    public static void main(String[] args) {

    	UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
		System.out.println(ubst.numTrees(1));
		System.out.println(ubst.numTrees(2));
		System.out.println(ubst.numTrees(3));
		System.out.println(ubst.numTrees(4));
	}
}
