package lcoj.string;

import java.util.Arrays;


public class ScrambleString {

  // 丧心病狂的 three dimension DP
  // Will take O(N^3) time even using DP

  // recursive is simple, but will TLE
  // need to do some pruning (by sorting)

  // a simple recursive solution
  public static boolean isScramble(String s1, String s2) {

    // System.out.println(s1 + " " + s2);

    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }

    if (s1.equals(s2)) {
      return true;
    }

    for (int i = 1 ; i < s1.length() ; i++) {
      for (int j = 1 ; j < s2.length() ; j++) {
        String s11 = s1.substring(0, i);
        String s12 = s1.substring(i);
        String s21 = s2.substring(0, j);
        String s22 = s2.substring(j);

        // Aha, sorting is the trick of this question
        char[] s11Char = s11.toCharArray();
        char[] s12Char = s12.toCharArray();
        char[] s21Char = s21.toCharArray();
        char[] s22Char = s22.toCharArray();

        Arrays.sort(s11Char);
        Arrays.sort(s12Char);
        Arrays.sort(s21Char);
        Arrays.sort(s22Char);

        if (new String(s11Char).equals(new String(s21Char)) && new String(s12Char).equals(new String(s22Char))) {
          if (isScramble(s11, s21) && isScramble(s12, s22)) {
            return true;
          }
        }

        if (new String(s11Char).equals(new String(s22Char)) && new String(s12Char).equals(new String(s21Char))) {
          if (isScramble(s11, s22) && isScramble(s12, s21)) {
            return true;
          }
        }

        // if ((isScramble(s11, s21) && isScramble(s12, s22)) || (isScramble(s11, s22) && isScramble(s12, s21))) {
        // return true;
        // }
      }
    }

    return false;
  }


  public static void main(String[] args) {

    String s1 = "rgtae";
    String s2 = "great";
    System.out.println(isScramble(s1, s2));

    s1 = "abcdefghijklmnopq";
    s2 = "efghijklmnopqcadb";
    System.out.println(isScramble(s1, s2));
  }
}
