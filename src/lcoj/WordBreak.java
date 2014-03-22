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

	Set<String> cache = new HashSet<String>();

	// DP solution
	public boolean wordBreak(String s, Set<String> dict) {

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

	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		String[] strings = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		dict.addAll(Arrays.asList(strings));

		WordBreak wb = new WordBreak();
		String s = "aaaaaaaaaaaaaab";
		System.out.println(wb.wordBreakBF(s, dict));

		dict.clear();
		dict.add("a");
		dict.add("b");
		s = "ab";
		System.out.println(wb.wordBreakBF(s, dict));
	}
}
