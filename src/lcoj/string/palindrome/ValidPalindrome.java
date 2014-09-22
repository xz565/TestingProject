package lcoj.string.palindrome;

//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        
    	if(s.isEmpty()) {
    		return true;
    	}
    	
    	int head = 0;
    	int tail = s.length() - 1;
    	
    	s = s.toLowerCase();
    	while(head < tail) {
    		
    		while(head < s.length() && !Character.isLetterOrDigit(s.charAt(head))) {
    			head++;
    		}
    		while(tail >= 0 && !Character.isLetterOrDigit(s.charAt(tail))) {
    			tail--;
    		}
    		
    		// this line is cool
    		if(head == s.length() || tail == -1) break;
    		
    		if(s.charAt(head) == s.charAt(tail)) {
    			head++;
    			tail--;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }


	public static void main(String[] args) {
		
    	ValidPalindrome vp = new ValidPalindrome();
    	
    	System.out.println(vp.isPalindrome(""));
    	System.out.println(vp.isPalindrome(" "));
    	System.out.println(vp.isPalindrome("w,.,.,"));
    	System.out.println(vp.isPalindrome("..,,.,,"));
	}
}
