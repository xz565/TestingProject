package lcoj.recursive;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * [
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
   ]
 * @author Xiaodong Zhang
 *
 */
public class PascalsTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

    	if(numRows == 0) {
    		return results;
    	}
    	
    	helper(numRows, results);
        
    	return results;
    }

	private void helper(int numRows, ArrayList<ArrayList<Integer>> results) {
		
		ArrayList<Integer> currtRow = new ArrayList<Integer>();
		if(numRows == 1) {
			currtRow.add(1);
			results.add(currtRow);
			return;
		}
		
		helper(numRows - 1, results);
		
		ArrayList<Integer> lastRow = results.get(numRows - 2);
		currtRow.add(1);
		for(int i = 0; i < lastRow.size() - 1; i++) {
			currtRow.add(lastRow.get(i) + lastRow.get(i + 1));
		}
		currtRow.add(1);
		results.add(currtRow);
	}
	
	public static void main(String[] args) {
		PascalsTriangle pascalsTriangle = new PascalsTriangle();
		System.out.println(pascalsTriangle.generate(5));
	}
}
