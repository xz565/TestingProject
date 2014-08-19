package lcoj.recursive.parentheses;

import java.util.Stack;

// Given a string containing just the characters '(' and ')',
// find the length of the longest valid (well-formed) parentheses substring.
//
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public class LongestValidParentheses {

  // failed on test case "()(()"
  public static int longestValidParentheses_Wrong(String s) {

    Stack<Character> stack = new Stack<Character>();

    // a rule to keep is that '(' must not smaller than ')'
    // ())()false
    int max = 0;
    int tempMax = 0;

    // ///////////////////////////////////
    // WE DON'T PUT ')' INTO THE STACK///
    // //////////////////////////////////
    for (int i = 0 ; i < s.length() ; i++) {
      char ch = s.charAt(i);
      if (ch == '(') { // left is easy, always push it to the stack
        stack.push(ch);
      } else { // ')'
        if (stack.isEmpty()) {
          // leftIdx = i + 1;
          tempMax = 0;
        } else {
          stack.pop();
          tempMax += 2;
          if (tempMax > max) {
            max = tempMax;
          }
        }
      }
    }

    return max;
  }


  public static int longestValidParentheses(String s) {

    int max = 0;
    int start = 0;

    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0 ; i < s.length() ; i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        stack.push(i);
      } else {
        if (stack.isEmpty()) {
          start = i + 1;
        } else {
          // 好像挺有道理....
          stack.pop();
          if (stack.isEmpty()) {
            max = Math.max(max, i - start + 1);
          } else {
            max = Math.max(max, i - stack.peek());
          }
        }
      }
    }


    return max;

  }


  public static void main(String[] args) {

    String s = ")()())";
    System.out.println(longestValidParentheses(s));
  }
}
