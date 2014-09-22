package lcoj.simulation;

/*
 * Input:	[4,2,0,3,2,5]
Output:	6
Expected:	9

 */


public class TrappingRainWater {

	// This is slow, but still got ACed
	public static int trap(int[] A) {

		int capacity = 0;
		

		for (int i = 0; i < A.length; i++) {

			int leftHigh = 0;
			int rightHigh = 0;
			
			int currentHigh = A[i];

			// look left
			for (int j = i - 1; j >= 0; j--) {
				if(A[j] >= leftHigh /* && A[j] >= currentHigh */) {
					leftHigh = A[j];
				} /*else {
					break;
				}*/
			}

			// look right
			for (int j = i + 1; j < A.length; j++) {
				if(A[j] >= rightHigh/* && A[j] >= currentHigh */) {
					rightHigh = A[j];
				} /*else {
					break;
				}*/
			}
			
			
			if(Math.min(leftHigh, rightHigh) > currentHigh) {
				capacity += Math.min(leftHigh, rightHigh) - currentHigh;
			}
			
			System.out.println("leftHigh: " + leftHigh + " rightHigh: " + rightHigh);
			//System.out.println(Math.min(leftHigh, rightHigh));
			System.out.println("added: " + (Math.min(leftHigh, rightHigh) - currentHigh));
			
		}

		return capacity;
	}

	// for each position, we don't need to go left and right
	// we need the leftMost info and rightMost info for each index
	// so we can go left and then go right, keep an array for hightest info
	public static int trap2(int[] A) {
		
		int sum = 0;
		
		int[] leftMost = new int[A.length];
		for(int i = 1; i < A.length; i++) {
			leftMost[i] = Math.max(leftMost[i - 1], A[i - 1]);
		}
		int rightMost = 0;
		for(int i = A.length - 2; i >= 1; i--) {
			rightMost = Math.max(rightMost, A[i + 1]);
			sum += Math.max(Math.min(leftMost[i], rightMost) - A[i], 0);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int[] A = {4,2,0,3,2,5};
		int[] A2 = {0, 2, 0};
		System.out.println("Total: " + TrappingRainWater.trap2(A));
		System.out.println("Total: " + TrappingRainWater.trap2(A2));
	}
}
