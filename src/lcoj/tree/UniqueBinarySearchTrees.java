package lcoj.tree;

import java.util.HashMap;
import java.util.Map;

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
