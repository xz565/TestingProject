package lcoj.array;

import lcoj.common.Util;

//You are given an n x n 2D matrix representing an image.
//
//Rotate the image by 90 degrees (clockwise).
//
//Follow up:
//Could you do this in-place?
public class RotateImage {

	// Boo, challenge of basic array manipulation skill
	// think clearly, code carefully
	
	//  1,  2,  3,  4
	//  5,  6,  7,  8
	//  9, 10, 11, 12
	// 13, 14, 15, 16
	
	// obvious with extra space
	// become more difficult then trying to solving in place
	
	// try with example with N == 4, u will easily find the pattern
    public void rotate(int[][] matrix) {
  
    	int len = matrix.length;
    	for(int i = 0; i < len / 2; i++) {
    		for(int j = i; j < len - 1 - i; j++) {
    			// (0, 1)
    			int temp = matrix[i][j];
    			// move top to right (1, 3)
    			temp = move(matrix, temp, j, len - 1 - i);
    			// move right to down (3, 1)
    			temp = move(matrix, temp, len - 1 - i, len - 1 - j);
    			// move down to left (1, 0)
    			temp = move(matrix, temp, len - 1 - j, i);
    			// move left to top (0, 1)
    			move(matrix, temp, i, j);
    		}
    	}
    }

	private int move(int[][] matrix, int val, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = val;
		return temp;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		Util.printMatrix(matrix);
		RotateImage rImage = new RotateImage();
		rImage.rotate(matrix);
		Util.printMatrix(matrix);
	}
}
