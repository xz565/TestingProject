package lcoj.array;

import java.util.Arrays;

//Given a non-negative number represented as an array of digits, plus one to the number.
//
//The digits are stored such that the most significant digit is at the head of the list.
public class PlusOne {

	// what is the point of this question???
	public int[] plusOne(int[] digits) {
		
		if(digits.length==0) return digits;

		boolean carry = false;
		for (int i = digits.length - 1; i >= 0; i--) {

			int curt = digits[i];

			// process least significant bit
			if (i == digits.length - 1) {
				if (curt == 9) {
					digits[i] = 0;
					carry = true;
					continue;
				} else {
					digits[i] += 1;
					return digits;
				}
			}

			if (carry && curt == 9) {
				digits[i] = 0;
				continue;
			} else {
				digits[i] += 1;
				return digits;
			}
		}

		int[] result = new int[digits.length + 1];
		result[0] = 1;
		for(int i = 0; i < digits.length; i++) {
			result[i+1] = digits[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		int[] digits = {1, 9, 9};
		System.out.println(Arrays.toString(plusOne.plusOne(digits )));
	}
}
