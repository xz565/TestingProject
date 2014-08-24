package lcoj.string.palindrome;

import java.util.ArrayList;


// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
//
// [
// ["aa","b"],
// ["a","a","b"]
// ]
public class PalindromePartitioning {

  public ArrayList<ArrayList<String>> partition(String s) {

    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();

    if (s.isEmpty()) {
      return results;
    }
    if (s.length() == 1) {
      ArrayList<String> e = new ArrayList<String>();
      e.add(s);
      results.add(e);
      return results;
    }

    for (int i = 1 ; i <= s.length() ; i++) {
      String head = s.substring(0, i);
      if (isPalindrome(head)) {
        ArrayList<ArrayList<String>> rst = partition(s.substring(i));
        for (ArrayList<String> al : rst) {
          al.add(0, head);
        }
        // Bug, should be very careful with edge case!
        if (i == s.length()) {
          ArrayList<String> e = new ArrayList<String>();
          e.add(head);
          results.add(e);
        }
        results.addAll(rst);
      }
    }


    return results;
  }


  private boolean isPalindrome(String str) {

    if (str.isEmpty()) {
      return true;
    }

    int head = 0;
    int tail = str.length() - 1;

    while (head < tail) {
      if (str.charAt(head) == str.charAt(tail)) {
        head++;
        tail--;
      } else {
        return false;
      }
    }

    return true;
  }


  public static void main(String[] args) {

    PalindromePartitioning pp = new PalindromePartitioning();
    System.out.println(pp.partition(""));
    System.out.println(pp.partition("a"));
    System.out.println(pp.partition("bb"));
    System.out.println(pp.partition("aab"));
    System.out.println(pp.partition("abba"));
  }
}
