package lcoj.recursive;

import java.util.ArrayList;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class Combinations {

	// similar to permutation
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
    	boolean[] arr = new boolean[n];
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> rst = new ArrayList<Integer>();
    	int count = 0; // difference with permutation
    	helper(result, rst, arr, k, count);
    	
		return result;
    }

	@SuppressWarnings("unchecked")
	private void helper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> rst, boolean[] arr, int k, int count) {
		
		if(rst.size() == k) {
			result.add((ArrayList<Integer>) rst.clone());
		}
		
		for(int i = count; i < arr.length; i++) {
			if(!arr[i]) {
				arr[i] = true;
				rst.add(i+1);
				count++;
				helper(result, rst, arr, k, count);
				arr[i] = false;
				rst.remove(rst.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Combinations comb = new Combinations();
		System.out.println(comb.combine(4, 2));
	}
}
