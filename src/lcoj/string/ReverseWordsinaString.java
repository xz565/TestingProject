package lcoj.string;

import java.util.Arrays;
import java.util.Stack;

/*
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification: What constitutes a word? A sequence of non-space characters constitutes a word. Could the input string contain leading or trailing spaces? Yes. However, your
 * reversed string should not contain leading or trailing spaces. How about multiple spaces between two words? Reduce them to a single space in the reversed string.
 */
public class ReverseWordsinaString {

  // Easy solution using Java Api
  // Note the difference between split(" ") and split(" +")
  // Time O(N) Space O(2N)
  public String reverseWords(String s) {

    if (s == null) {
      return null;
    }

    Stack<String> stack = new Stack<String>();
    stack.addAll(Arrays.asList(s.split(" +")));

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
      sb.append(" ");
    }

    return sb.toString().trim();
  }


  // A solution by String manipulation
  public String reverseWords2(String s) {

    if (s == null) {
      return null;
    }

    s = s.trim();
    int start = 0;
    int runner = 1;
    boolean spaceFlag = false;
    Stack<String> stack = new Stack<String>();
    while (runner <= s.length()) {
      if (!spaceFlag && ' ' == (s.charAt(runner - 1))) {
        stack.push(s.substring(start, runner));
        start = runner;
        spaceFlag = true;
      } else if (spaceFlag && !(' ' == s.charAt(runner - 1))) {
        stack.push(s.substring(start, runner));
        start = runner;
        spaceFlag = false;
      } else if (runner == s.length()) {
        stack.push(s.substring(start, runner));
      }
      runner++;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }


  public static void main(String[] args) {

    ReverseWordsinaString reverse = new ReverseWordsinaString();
    String str = "the     sky is blue";
    System.out.println(reverse.reverseWords(str));
    str = "";
    System.out.println(reverse.reverseWords(str));
    System.out.println(reverse.reverseWords(str).length());
  }
}
