package lcoj.array;

// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ... 312211
//
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.
//
// Note: The sequence of integers will be represented as a string.
public class CountAndSay {

  public String countAndSay(int n) {

    StringBuffer sb = new StringBuffer("1");

    for (int i = 1 ; i < n ; i++) {
      String str = sb.toString();
      sb.setLength(0);
      int count = 1;
      for (int j = 1 ; j <= str.length() ; j++) {

        if (j == str.length()) {
          sb.append(count).append(str.charAt(j - 1));
        } else if (str.charAt(j) == str.charAt(j - 1)) {
          count++;
        } else {
          sb.append(count).append(str.charAt(j - 1));
          count = 1;
        }
      }
    }

    return sb.toString();
  }


  public static void main(String[] args) {

    CountAndSay countAndSay = new CountAndSay();
    System.out.println(countAndSay.countAndSay(1));
    System.out.println(countAndSay.countAndSay(2));
    System.out.println(countAndSay.countAndSay(3));
    System.out.println(countAndSay.countAndSay(4));
    System.out.println(countAndSay.countAndSay(5));
    System.out.println(countAndSay.countAndSay(6));
    System.out.println(countAndSay.countAndSay(7));
  }
}
