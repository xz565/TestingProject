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

  // assumption: negative numbers are not palindrome
  public boolean isPalindrome(int x) {

    if (x < 0) {
      return false;
    }

    int div = 1;
    while (x / div > 10) {
      div *= 10;
    }

    System.out.println(div);

    while (x != 0) {
      int lastBit = x % 10;
      int firstBit = x / div;

      System.out.println(firstBit + " " + lastBit);
      if (lastBit != firstBit) {
        return false;
      }
      x = x - div - lastBit;
      div = div / 100;
    }

    return true;
  }


  public static void main(String[] args) {

    int x = 1234321;
    PalindromeNumber palindromeNumber = new PalindromeNumber();
    System.out.println(palindromeNumber.isPalindrome(x));
  }
}
