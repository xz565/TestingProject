package lcoj.recursive;

import java.util.ArrayList;
import java.util.List;

// Given a digit string, return all possible
// letter combinations that the number could represent.
//
// A mapping of digit to letters
// (just like on the telephone buttons) is given below.
public class LetterCombinationsOfAPhoneNumber {

  // 举个栗子
  // Input:Digit string "23"
  // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

  public List<String> letterCombinations(String digits) {

    String trans[] = { "", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    List<String> result = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    helper(trans, result, sb, digits, 0);

    return result;
  }


  private void helper(String[] trans, List<String> list, StringBuilder sb, String digits, int idx) {

    if (idx >= digits.length()) {
      list.add(sb.toString());
      return;
    }

    String curtStr = trans[digits.charAt(idx) - '0'];
    for (int i = 0 ; i < curtStr.length() ; i++) {
      char ch = curtStr.charAt(i);
      sb.append(ch);
      helper(trans, list, sb, digits, idx + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }


  public static void main(String[] args) {

    LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
    System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("234"));
  }
}
