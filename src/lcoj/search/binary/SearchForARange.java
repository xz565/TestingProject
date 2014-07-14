package lcoj.search.binary;

import java.util.Arrays;


public class SearchForARange {

  public int[] searchRange(int[] A, int target) {

    if (A == null) {
      return new int[] { -1, -1 };
    }
    int[] result = new int[2];

    // search for lower bound
    int lower = lowerHelper(A, target, 0, A.length - 1);
    int higher = higherHelper(A, target, 0, A.length - 1);

    result[0] = lower;
    result[1] = higher;
    return result;
  }


  private int higherHelper(int[] A, int target, int left, int right) {

    if (left > right) {
      return -1;
    }

    int mid = (left + right) / 2;
    int midVal = A[mid];
    if (midVal == target) {
      if (mid == A.length - 1 || A[mid + 1] > target) {
        return mid;
      }
      return higherHelper(A, target, mid + 1, right);
    } else if (midVal < target) {
      return higherHelper(A, target, mid + 1, right);
    } else {
      return higherHelper(A, target, left, mid - 1);
    }
  }


  private int lowerHelper(int[] A, int target, int left, int right) {

    if (left > right) {
      return -1;
    }

    int mid = (left + right) / 2;
    int midVal = A[mid];
    if (midVal == target) {
      if (mid == 0 || A[mid - 1] < target) {
        return mid;
      }
      return lowerHelper(A, target, left, mid - 1);
    } else if (midVal < target) {
      return lowerHelper(A, target, mid + 1, right);
    } else {
      return lowerHelper(A, target, left, mid - 1);
    }
  }


  public static void main(String[] args) {

    int[] A = { 1, 5, 7, 7, 8, 8, 8, 10, 11 };
    SearchForARange searchForARange = new SearchForARange();
    System.out.println(Arrays.toString(searchForARange.searchRange(A, 8)));
  }
}
