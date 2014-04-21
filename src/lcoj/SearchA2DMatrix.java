package lcoj;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. 
 * The first integer of each row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 100],
 * [10, 11, 200, 300], 
 * [23, 30, 34, 50] ] 
 * 
 * Given target = 3, return true.
 * 
 * @author NZWFLK
 * 
 */
public class SearchA2DMatrix {

  // tricky question, Yong's matrix
  // search from lower left corner to determine the row
  // then within a row, use binary search
  // overall time complexity is O(N) + O(lgM)
  
  // compare to binary search in each row which is O(NlgM)
  public boolean searchMatrix(int[][] matrix, int target) {

    
    return false;
  }
}
