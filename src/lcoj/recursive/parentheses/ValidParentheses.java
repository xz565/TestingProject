package lcoj.recursive.parentheses;

import java.util.Stack;


// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class ValidParentheses {

  // not a recursive, put it here because it's name

  // easy to solve using some extra memory
  // left should greater or equal to right
  // and at the end, left and right should be equal
  public boolean isValid(String s) {

    // Map<Character, Integer> map = new HashMap<Character, Integer>();
    // better to use a stack

    Stack<Character> stack = new Stack<Character>();


    for (int i = 0 ; i < s.length() ; i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else {

        // corner case
        if (stack.isEmpty()) {
          return false;
        }

        char leftCh;
        if (ch == ')') {
          leftCh = '(';
        } else if (ch == ']') {
          leftCh = '[';
        } else {
          leftCh = '{';
        }

        char leftPop = stack.pop();
        if (leftCh != leftPop) {
          return false;
        }
      }
    }

    if (!stack.isEmpty()) {
      return false;
    }

    return true;
  }


  public static void main(String[] args) {

    ValidParentheses validParentheses = new ValidParentheses();
    String str = ")";
    System.out.println(validParentheses.isValid(str));
  }
}
