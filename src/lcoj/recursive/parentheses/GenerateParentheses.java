package lcoj.recursive.parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author NZWFLK
 * 
 */
public class GenerateParentheses {

  // recursive for n based on n-1
  public ArrayList<String> generateParenthesis(int n) {

    ArrayList<String> result = new ArrayList<String>();

    if (n == 0) {
      return result;
    }

    if (n == 1) {
      result.add("()");
    } else {
      List<String> last = generateParenthesis(n - 1);
      Set<String> curt = new HashSet<String>();
      for (String p : last) {
        for (int i = 0 ; i < p.length() ; i++) {
          StringBuilder sb = new StringBuilder(p);
          sb.insert(i, '(');
          sb.insert(i + 1, ')');
          if (!curt.contains(sb.toString())) {
            curt.add(sb.toString());
          }
        }
      }
      result.addAll(curt);
    }

    return result;
  }


  public static void main(String[] args) {

    GenerateParentheses gen = new GenerateParentheses();
    System.out.println(gen.generateParenthesis(0));
    System.out.println(gen.generateParenthesis(1));
    System.out.println(gen.generateParenthesisDFS(1));
    System.out.println(gen.generateParenthesis(2));
    System.out.println(gen.generateParenthesisDFS(2));
    System.out.println(gen.generateParenthesis(3));
    System.out.println(gen.generateParenthesisDFS(3));
  }


  public List<String> generateParenthesisDFS(int n) {

    List<String> rst = new ArrayList<String>();
    StringBuffer sb = new StringBuffer();
    helper(rst, sb, n, n);

    return rst;
  }


  private void helper(List<String> rst, StringBuffer sb, int leftRemain, int rightRemain) {

    if (leftRemain == 0 && rightRemain == 0) {
      rst.add(sb.toString());
    } else if (leftRemain < 0 || rightRemain < 0) {
      return;
    } else {
      if (leftRemain > 0) {
        sb.append("(");
        helper(rst, sb, leftRemain - 1, rightRemain);
        sb.delete(sb.length() - 1, sb.length());
      }

      if (rightRemain > leftRemain) {
        sb.append(")");
        helper(rst, sb, leftRemain, rightRemain - 1);
        sb.delete(sb.length() - 1, sb.length());
      }
    }
  }
}
