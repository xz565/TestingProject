package lcoj.common;

import java.util.Arrays;

public class Util {
	
	public static void printMatrix(int[][] matrix) {
		for(int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
}