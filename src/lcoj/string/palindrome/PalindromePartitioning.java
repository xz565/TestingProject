package lcoj.string.palindrome;

import java.util.ArrayList;
import java.util.List;


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

	// bad base case, line 28 - 33 and 43 -47 is not good, see solution 2
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
  
  public List<List<String>> partition2(String s) {
      List<List<String>> rst = new ArrayList<List<String>>();
      if(s == null || s.isEmpty()) {
	      List<String> tmp = new ArrayList<String>();
	      rst.add(tmp);
          return rst;
      }
      
      for(int i = 0; i < s.length(); i++) {
          String curt = s.substring(0, i + 1);
          if(isPalindrome(curt)) {
              List<List<String>> tmp = partition2(s.substring(i + 1));
              for(List<String> list : tmp) {
                  list.add(0, curt);
              }
              rst.addAll(tmp);
          }
      }
      
      return rst;
  }

  public static void main(String[] args) {

    PalindromePartitioning pp = new PalindromePartitioning();
    System.out.println(pp.partition2(""));
    System.out.println(pp.partition2("a"));
    System.out.println(pp.partition2("bb"));
    System.out.println(pp.partition2("aab"));
    System.out.println(pp.partition2("abba"));
  }
}
