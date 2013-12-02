package lcoj;

import java.util.Stack;

/*
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 * ["4", "13", "5", "/","+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

	Stack<Integer> stack = new Stack<Integer>();

	for (String token : tokens) {
	    if (isNum(token)) {
		stack.push(Integer.parseInt(token));
	    } else {
		int result = calc(token, stack);
		stack.push(result);
	    }
	}

	if (stack.size() == 1) {
	    return stack.pop();
	} else {
	    return 0;
	}
    }

    private int calc(String token, Stack<Integer> stack) {
	int d2 = stack.pop();
	int d1 = stack.pop();

	if ("+".equals(token)) {
	    return d1 + d2;
	} else if ("-".equals(token)) {
	    return d1 - d2;
	} else if ("*".equals(token)) {
	    return d1 * d2;
	} else if ("/".equals(token)) {
	    return d1 / d2;
	}

	return 0;
    }

    private boolean isNum(String ch) {
	try {
	    Integer.parseInt(ch);
	} catch (NumberFormatException ex) {
	    return false;
	}
	return true;
    }

    public static void main(String[] args) {
	String[] strings = { "4", "13", "5", "/", "+" };
	EvaluateReversePolishNotation eva = new EvaluateReversePolishNotation();
	System.out.println(eva.evalRPN(strings));
    }
}
