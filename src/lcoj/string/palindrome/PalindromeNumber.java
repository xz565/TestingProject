package lcoj.string.palindrome;

// Determine whether an integer is a palindrome. Do this without extra space.
//
// click to show spoilers.
//
// Some hints:
// Could negative integers be palindromes? (ie, -1)
//
// If you are thinking of converting the integer to string, note the restriction of using extra space.
//
// You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such
// case?
//
// There is a more generic way of solving this problem.
public class PalindromeNumber {

  // though: / and % operations are useful when dealing with integer number
  // assumption: negative numbers are not palindrome
  public boolean isPalindrome(int x) {

    if (x < 0) {
      return false;
    }

    int div = 1;
    while (x / div >= 10) { // this equal is important
      div *= 10;
    }

System.out.println(div);
    while (x != 0) {
    	
    	System.out.println(x);
      int lastBit = x % 10;
      int firstBit = x / div;
System.out.println(lastBit + " " + firstBit);
      if (lastBit != firstBit) {
        return false;
      }
      x = (x % div) / 10;
      
      div /= 100;
    }

    return true;
  }


  public static void main(String[] args) {

    int x ;
    PalindromeNumber palindromeNumber = new PalindromeNumber();
    
//    x = 1234321;
//    System.out.println(palindromeNumber.isPalindrome(x));
//  
//    x = 2147483647;
//    System.out.println(palindromeNumber.isPalindrome(x));
//    
    x = 1001;
    System.out.println(palindromeNumber.isPalindrome(x));
    
    
  }
}
