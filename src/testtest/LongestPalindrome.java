package testtest;

public class LongestPalindrome {

	public static String longestPalindrome(String s) {
	
		String longestString = "";
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = i ; j < s.length(); j++) {
				if(isPalindrome(s, i, j)) {
					String temp = s.substring(i, j + 1);
					if(temp.length() > longestString.length()) {
						longestString = temp;
					}
				}
			}
		}
		
		return longestString;
	}

	public static boolean isPalindrome(String s, int left, int right) {
		if (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				return isPalindrome(s, left + 1, right - 1);
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
		long start = System.currentTimeMillis();
		System.out.println(longestPalindrome(s).length());
		System.out.println(System.currentTimeMillis() - start);
	}
}
