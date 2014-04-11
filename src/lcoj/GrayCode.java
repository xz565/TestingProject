package lcoj;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 
 * 01 - 1 
 * 11 - 3 
 * 10 - 2
 * 
 * @author Xiaodong Zhang
 * 
 */
public class GrayCode {

	// hardest part of this question is to find the pattern
	// especial the reverse and add
	public static ArrayList<Integer> grayCode(int n) {

		ArrayList<Integer> results = new ArrayList<Integer>();

		if(n == 0) {
			results.add(0);
			return results;
		}

		
		ArrayList<Integer> rst = grayCode(n - 1);
		results.addAll(rst);
		Stack<Integer> stack = new Stack<Integer>();
		stack.addAll(results);
		while(!stack.isEmpty()) {
			int i = stack.pop();
			int j = (1 << n-1) ^ i;
			results.add(j);
		}

		return results;
	}
	
	public static void main(String[] args) {
		System.out.println(grayCode(0));
		System.out.println(grayCode(1));
		System.out.println(grayCode(2));
		System.out.println(grayCode(3));
	}
}
