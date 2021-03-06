package lcoj.math;

import java.util.Arrays;


// Given two numbers represented as strings, return multiplication of the numbers as a string.
//
// Note: The numbers can be arbitrarily large and are non-negative.
public class MultiplyStrings {

  // It's not a good idea to do this using hand multiple method
  // hand multiple uses multiple and plus operation which will still cause overflow on big integer
  //
  // Big integer multiple is a good example of Divide and Conquer technique
  // for AB*CD, can convert to AC(AD+BD)BD, and each can be up to 4 digits without overflow in normal computer
  //
  // To solve this problem simple and fast, some other tricks can also be applied
  // we can utilize the index to proper set the value in each bit
  // 我只能说，这个算法碉堡了!!
  // This algorithm uses a very good observation about multiply.
  public String multiply(String num1, String num2) {

    StringBuffer sb = new StringBuffer();

    num1 = new StringBuffer(num1).reverse().toString();
    num2 = new StringBuffer(num2).reverse().toString();

    // this array stores
    int[] arr = new int[num1.length() + num2.length()];
    for (int i = 0 ; i < num1.length() ; i++) {
      int a = num1.charAt(i) - '0';
      for (int j = 0 ; j < num2.length() ; j++) {
        int b = num2.charAt(j) - '0';
        arr[i + j] += a * b;
      }
    }

    System.out.println(Arrays.toString(arr));

    int carry = 0;
    for (int i : arr) {
      i += carry;
      sb.insert(0, (i % 10));
      carry = i / 10;
    }

    System.out.println(sb.toString());

    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }

    return sb.toString();
  }


  public static void main(String[] args) {

    MultiplyStrings multiplyStrings = new MultiplyStrings();

    String num1 = "6";
    String num2 = "501";
    System.out.println(multiplyStrings.multiply(num1, num2));

    num1 = "12345";
    num2 = "54321";
    System.out.println(multiplyStrings.multiply(num1, num2));

    num1 = "0";
    num2 = "0";
    System.out.println(multiplyStrings.multiply(num1, num2));

    num1 = "0";
    num2 = "9133";
    System.out.println(multiplyStrings.multiply(num1, num2));
  }
}
