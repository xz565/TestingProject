package lcoj.recursive;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets.
 * 
 * @author amixyz0
 * 
 */
public class Subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {

		Arrays.sort(S);
		return helper(S, S.length - 1);
	}

	private ArrayList<ArrayList<Integer>> helper(int[] s, int idx) {

		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		if (idx < 0) {
			ArrayList<Integer> empt = new ArrayList<Integer>();
			results.add(empt);
			return results;
		}

		ArrayList<ArrayList<Integer>> prev = helper(s, idx - 1);
		ArrayList<ArrayList<Integer>> curt = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> a : prev) {
			@SuppressWarnings("unchecked")
			ArrayList<Integer> b = (ArrayList<Integer>) a.clone();
			b.add(s[idx]);
			curt.add(b);
		}
		results.addAll(prev);
		results.addAll(curt);

		return results;
	}

	public static void main(String[] args) {

		Subsets s = new Subsets();
		System.out.println(s.subsets(new int[] {}));
		System.out.println(s.subsets(new int[] { 1 }));
		System.out.println(s.subsets(new int[] { 1, 2 }));
	}
}
