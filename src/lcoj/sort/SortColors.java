package lcoj.sort;


public class SortColors {

	// one pass is little tricky
	public void sortColors(int[] A) {

		int zeroPointer = 0;
		int twoPointer = A.length - 1;

		for (int i = 0; i <= twoPointer; i++) {
			int curt = A[i];
			if (curt == 0) {
				if(i != zeroPointer) {
					// switch with zeroPointer
					A[i] = A[zeroPointer];
					A[zeroPointer] = curt;
					i--;					
				}
				zeroPointer++;
			} else if (curt == 1) {
				// go ahead
				continue;
			} else if (curt == 2) {
				// switch with twoPointer
				A[i] = A[twoPointer];
				A[twoPointer] = curt;
				twoPointer--;
				i--;
			}
		}
	}

	// naive
	public void sortColorsTwoPass(int[] A) {

		int zeroCount = 0;
		int oneCount = 0;

		for (int a : A) {
			if (a == 0) {
				zeroCount++;
			} else if (a == 1) {
				oneCount++;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (i < zeroCount) {
				A[i] = 0;
			} else if (i >= zeroCount && i < zeroCount + oneCount) {
				A[i] = 1;
			} else if (i >= zeroCount + oneCount) {
				A[i] = 2;
			}
		}
	}

	public static void main(String[] args) {

		int[] A = { 0};

		SortColors sColors = new SortColors();
		sColors.sortColors(A);

		for (int a : A) {
			System.out.print(a + " ");
		}
	}
}
