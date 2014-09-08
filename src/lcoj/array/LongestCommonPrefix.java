package lcoj.array;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author Xiaodong Zhang
 * 
 */
public class LongestCommonPrefix {

	// O(kN) - k is the length of the longest common prefix
	public String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";

		String prefix = strs[0];
		for (String str : strs) {
			if (str.length() < prefix.length()) {
				prefix = str;
			}
		}

		for (String str : strs) {
			int i;
			for (i = 0; i < prefix.length(); i++) {
				if (prefix.charAt(i) != str.charAt(i)) {
					prefix = prefix.substring(0, i);
				}
			}
		}

		return prefix;
	}

	public static void main(String[] args) {

		String[] strs = {};

		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
	}
}
