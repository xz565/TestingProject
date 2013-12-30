package lcoj;

/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

	public int removeElement(int[] A, int elem) {

		int len = A.length - 1;
		int idx = 0;

		while(idx <= len) {
			if(A[idx] == elem) {
				A[idx] = A[len];
				len--;
			} else {
				idx++;
			}
		}
		return len + 1;
	}
	
	public static void main(String[] args) {
		int[] A = {3, 1};
		RemoveElement re = new RemoveElement();
		System.out.println(re.removeElement(A, 3));
	}

}
