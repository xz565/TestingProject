package lcoj.search.binary;

// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?
//
// Would this affect the run-time complexity? How and why?
//
// Write a function to determine if a given target is in the array.
public class SearchInRotatedSortedArrayII {

  // got AC, but not making any sense
  public boolean search2(int[] A, int target) {

    for (int a : A) {
      if (a == target) {
        return true;
      }
    }
    return false;
  }


  //
  public boolean search(int[] A, int target) {

    return false;
  }
}
