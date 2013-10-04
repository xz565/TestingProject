package lcoj;

/*
 * Input:	[4,2,0,3,2,5]
Output:	6
Expected:	9

 */


public class TrappingRainWater {

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

	public static void main(String[] args) {
		
		int[] A = {4,2,0,3,2,5};
		System.out.println("Total: " + TrappingRainWater.trap(A));
	}
}
