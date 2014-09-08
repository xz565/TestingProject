package lcoj.string;

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example, 
//Given s = "Hello World",
//return 5.
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean flag = false;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == ' ') {
    			flag = true;
    		} else {
    			if(flag) {
    				len = 1;
    				flag = false;
    			} else {
    				len++;
    			}
    		}
    	}
    	return len;
    }
    
    public static void main(String[] args) {
		String s = " Hello World   ";
		LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
		System.out.println(lengthOfLastWord.lengthOfLastWord(s));
	}
}
