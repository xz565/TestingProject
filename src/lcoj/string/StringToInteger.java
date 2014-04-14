package lcoj.string;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * @author NZWFLK
 * 
 */
public class StringToInteger {

  // hard part is clear the vague question
  // in each situation, what should we return
  public int atoi(String str) {

    str = str.trim();
    if (str.isEmpty()) {
      return 0;
    }

    int sum = 0;
    int sign = 1;

    for (int i = 0 ; i < str.length() ; i++) {

      char curtChar = str.charAt(i);
      int curt = curtChar - 48;

      if (i == 0 && curtChar == '+') {
        continue;
      } else if (i == 0 && curtChar == '-') {
        sign = -1;
      } else if (curt >= 0 && curt <= 9) {

        if (sign == 1 && (Integer.MAX_VALUE - curt) / 10 < sum) {
          return Integer.MAX_VALUE;
        } else if (sign == -1 && (Integer.MIN_VALUE + curt) / 10 > -1 * sum) {
          return Integer.MIN_VALUE;
        }

        sum = sum * 10 + curt;

      } else {
        return sum * sign;
      }
    }

    return sum * sign;
  }


  public static void main(String[] args) {

    StringToInteger atoi = new StringToInteger();
    System.out.println(atoi.atoi(""));
    System.out.println(atoi.atoi("0"));
    System.out.println(atoi.atoi("-0"));
    System.out.println(atoi.atoi("1"));
    System.out.println(atoi.atoi("-1"));
    System.out.println(atoi.atoi("123"));
    System.out.println(atoi.atoi("-123"));
    System.out.println(atoi.atoi("-123888888888888888888"));
    System.out.println(atoi.atoi("+1"));
    System.out.println(atoi.atoi("-123(hduo"));
    System.out.println(atoi.atoi("-2147483647"));
    System.out.println(atoi.atoi("-2147483648"));
    System.out.println(atoi.atoi("    -00134"));
  }
}
