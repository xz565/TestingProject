package lcoj.math;

/*
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 */

// Have you thought about this?
// Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
//
// If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//
// Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//
// Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
public class ReverseInteger {

  public static int reverse_old(int x) {

    boolean neg = false;

    if (x < 0) {
      x *= -1;
      neg = true;
    }

    StringBuffer sb = new StringBuffer(String.valueOf(x));
    int left = 0;
    int right = sb.length() - 1;
    while (left < right) {
      char leftChar = sb.charAt(left);
      char rightChar = sb.charAt(right);
      sb.setCharAt(left, rightChar);
      sb.setCharAt(right, leftChar);
      left++;
      right--;
    }

    return neg ? Integer.parseInt("-" + sb.toString()) : Integer.parseInt(sb.toString());
  }


  public static int reverse(int x) {

    int rst = 0;
    int lastBit;
    while (x != 0) {
      lastBit = x % 10;
      rst = rst * 10 + lastBit;
      x /= 10;
    }
    return rst;
  }


  public static void main(String[] args) {

    System.out.println(reverse(-4321));
    System.out.println(reverse(-10100));

    // OJ test cases don't consider the over flow cases
    System.out.println(reverse(1000000003));
  }
}
