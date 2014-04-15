package lcoj.bit;

/**
 * Given an array of integers, every element appears three 
 * times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * @author Xiaodong Zhang
 *
 */
public class SingleNumberII {

    public static int singleNumber(int[] A) {
     
    	int result = 0;
    	
    	for(int i = 0; i < 32; i++) {
    		int sum = 0;
    		int r = 0;
    		for(int j = 0; j < A.length; j++) {
    			sum += (A[j] >> i) & 1;
    		}
    		r = sum % 3;
    		result |= r << i;
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		int[] A = {3,1,3,1,2,1,3};
		System.out.println(singleNumber(A));
	}
}