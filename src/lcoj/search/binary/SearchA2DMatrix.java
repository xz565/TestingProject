package lcoj.search.binary;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. 
 * The first integer of each row is greater than the LAST integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7],
 * [8, 11, 15, 20], 
 * [23, 30, 34, 50] ] 
 * 
 * Given target = 3, return true.
 * 
 * @author NZWFLK
 * 
 */
public class SearchA2DMatrix {

  // binary search
  // log (m+n)
  public boolean searchMatrix(int[][] matrix, int target) {

    int head = 0;
    int tail = matrix.length*matrix[0].length - 1;
    int colm = matrix[0].length;
    
    while(head <= tail) {
    	
    	int mid = head + (tail - head) / 2;
    	int row = mid / colm;
    	int col = mid % colm;

    	if(matrix[row][col] == target) {
    		return true;
    	}
    	if(matrix[row][col] < target) {
    		head = mid + 1; // !!! important
    	} else {
    		tail = mid - 1; // !!! important
    	}
    	
    }
    
    return false;
  }
  
  public static void main(String[] args) {
	
	  int[][] matrix = {{1, 3}};
	  SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
	  System.out.println(searchA2DMatrix.searchMatrix(matrix, 7));
  }
}
