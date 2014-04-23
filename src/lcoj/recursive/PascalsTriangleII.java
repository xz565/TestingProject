package lcoj.recursive;

import java.util.ArrayList;

// Given an index k, return the kth row of the Pascal's triangle.
//
// For example, given k = 3,
// Return [1,3,3,1].
//
// Note:
// Could you optimize your algorithm to use only O(k) extra space?
public class PascalsTriangleII {

  // How much space does this solution take?
  //
  public ArrayList<Integer> getRow(int rowIndex) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    if (rowIndex < 0) {
      return result;
    }
    if (rowIndex == 0) {
      result.add(1);
      return result;
    }

    ArrayList<Integer> prev = getRow(rowIndex - 1);
    result.add(1);
    
    // point
    for (int i = 0 ; i < prev.size() - 1 ; i++) {
      result.add(prev.get(i) + prev.get(i + 1));
    }
    result.add(1);

    return result;
  }


  public static void main(String[] args) {

    PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
    System.out.println(pascalsTriangleII.getRow(2));
  }
}
