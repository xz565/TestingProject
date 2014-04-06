package lcoj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {


	// this is a standard DP solution
	public boolean wordBreak(String s, Set<String> dict) {
		
		// dp[i] means sub string 0 to i can be broken
		boolean[] dp = new boolean[s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			if(dict.contains(s.substring(0, i+1))) {
				dp[i] = true;
			}
		}
		
		for(int i = 1; i < s.length(); i++) {
			for(int j = 0; j < i; j++) {
				if(dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
					dp[i] = true;
				}
			}
		}
		
		return dp[s.length()-1];
	}
	
	
	// this is a tricky solution
	// it's not like DP, more like a prune technology
	Set<String> cache = new HashSet<String>();
	
	// DP solution
	// The hardest part of DP problem is to abstract the repetition part of the algorithm and store them properly
	// 
	public boolean wordBreakPrune(String s, Set<String> dict) {

		if(s.isEmpty()) return true;
		
		boolean flag = false;
		
		for(int i = 1; i <= s.length(); i++) {
			
			String prefix = s.substring(0, i);
			
			if(dict.contains(prefix)) {
				
				String suffix = s.substring(i);
				
				if(cache.contains(suffix)) {
					continue;
				} else {
					flag = wordBreakPrune(suffix, dict);
					
					if(flag) {
						return true; 
					} else{
						cache.add(suffix);
					}
				}
			}
		}
		
		return false;
	}

	// brute force solution
	public boolean wordBreakBF(String s, Set<String> dict) {

		if (s.length() == 0) {
			return true;
		}

		// DFS
		LinkedList<String> stack = new LinkedList<String>();
		stack.push(s);

		while (!stack.isEmpty()) {

			String currt = stack.pop();

			for (int i = 1; i <= currt.length(); i++) {
				String leftStr = currt.substring(0, i);
				String rightStr = currt.substring(i);
				if (dict.contains(leftStr)) {
					if (rightStr.isEmpty()) {
						return true;
					} else {
						stack.push(rightStr);
					}
				}
			}
		}

		return false;
	}
	
	// DFS
	// TLE on aa...aab
	public boolean wordBreakBF2(String s, Set<String> dict) {
		
		if(s.isEmpty())
			return true;
		
		for(int i = 1; i <= s.length(); i++) {
			String subStr =  s.substring(0, i);
			if(dict.contains(subStr)) {
				if(wordBreakBF2(s.substring(i), dict)) {
					return true;
				}
			}
		}
		
		return false;
	}

		
		
	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		String[] strings = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		dict.addAll(Arrays.asList(strings));

		WordBreak wb = new WordBreak();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(wb.wordBreak(s, dict));

		wb.cache.clear();
		dict.clear();
		dict.add("a");
		dict.add("b");
		s = "ab";
		System.out.println(wb.wordBreak(s, dict));
	}
}
