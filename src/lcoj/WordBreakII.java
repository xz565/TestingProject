package lcoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {

	public ArrayList<String> wordBreak(String s, Set<String> dict) {

		ArrayList<String> results = new ArrayList<String>();
		Map<String, List<String>> path = new HashMap<String, List<String>>();

		// dp[i] means sub string 0 to i can be broken
		boolean[] dp = new boolean[s.length()];

		for (int i = 0; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				dp[i] = true;
				path.put(s.substring(0, i + 1), null);
			}
		}

		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {

				String currt = s.substring(0, i + 1);
				String prefix = s.substring(0, j + 1);

				if (dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
					dp[i] = true;

					List<String> child = path.get(currt);
					if (child == null) {
						ArrayList<String> aList = new ArrayList<String>();
						aList.add(prefix);
						path.put(currt, aList);
					} else {
						child.add(prefix);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if (!path.isEmpty() && dp[s.length() -1 ]) {
			buildResults(path, results, s, sb);
		}
		results = reverseResults(results);

		for (boolean b : dp)
			System.out.print(b + " ");
		System.out.println();
		System.out.println("path: " + path);

		return results;

	}

	private ArrayList<String> reverseResults(ArrayList<String> results) {

		ArrayList<String> results2 = new ArrayList<String>();
		for (String result : results) {

			String[] strs = result.split(" ");
			Stack<String> stack = new Stack<String>();
			for (String s : strs) {
				stack.push(s);
			}
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			results2.add(sb.toString().trim());
		}
		return results2;
	}

	private void buildResults(Map<String, List<String>> path,
			ArrayList<String> results, String s, StringBuilder sb) {

		List<String> ends = path.get(s);

		if (ends != null) {
			for (String str : ends) {

				String tail = s.replaceFirst(str, "");
				System.out.println(tail);
				StringBuilder sb2 = new StringBuilder(sb);
				sb2.append(tail).append(" ");

				buildResults(path, results, str, sb2);
			}
		} else {
			System.out.println(s);
			StringBuilder sb2 = new StringBuilder(sb);
			sb2.append(s);
			results.add(sb2.toString());
		}
	}

	Set<String> cache = new HashSet<String>();

	public ArrayList<String> wordBreakNotWorking(String s, Set<String> dict) {

		ArrayList<String> results = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();

		helper(s, dict, sb, results);

		return results;
	}

	private boolean helper(String s, Set<String> dict, StringBuffer sb,
			ArrayList<String> results) {

		// base case, add to the results
		if (s.isEmpty()) {
			results.add(sb.toString().trim());
			sb.setLength(0);
			return true;
		}

		for (int i = 1; i <= s.length(); i++) {

			String prefix = s.substring(0, i);

			if (dict.contains(prefix)) {
				sb.append(prefix).append(" ");

				String suffix = s.substring(i);
				if (cache.contains(suffix)) {
					continue;
				} else {
					boolean flag = helper(suffix, dict, sb, results);

					if (flag) {
						return true;
					} else {
						cache.add(suffix);
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		String[] strings = { "cat", "cats", "and", "sand", "dog" };
		dict.addAll(Arrays.asList(strings));

		WordBreakII wb = new WordBreakII();
		String s = "catsanddog";
		System.out.println(wb.wordBreak(s, dict));

		wb.cache.clear();
		dict.clear();
		dict.add("aaaa");
		dict.add("aa");
		dict.add("a");
		s = "aaaaaaa";
		System.out.println(wb.wordBreak(s, dict));
	}
}
