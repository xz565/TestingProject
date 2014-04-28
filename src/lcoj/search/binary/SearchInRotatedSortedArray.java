package lcoj.search.binary;

// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.
public class SearchInRotatedSortedArray {

  public int search1(int[] A, int target) {

    int head = 0;
    int tail = A.length - 1;
    int mid;

    while (head <= tail) {
      mid = (head + tail) / 2;
      if (target < A[mid]) {
        if (mid + 1 < A.length && A[mid + 1] < A[mid] && A[tail] >= target) {
          head = mid + 1;
        } else {
          tail = mid - 1;
        }
      } else if (target > A[mid]) {
        if (mid - 1 >= 0 && A[mid - 1] > A[mid] && A[head] <= target) {
          tail = mid - 1;
        } else {
          head = mid + 1;
        }
      } else {
        return mid;
      }
    }

    return -1;
  }


  // a deeper look of binary search
  public int search(int[] A, int target) {

    int head = 0;
    int tail = A.length - 1;
    int mid = 0;

    while (head <= tail) {
      mid = head + (tail - head) / 2;
      if (A[mid] == target) {
        return mid;
      }

      if (A[head] <= A[mid]) {
        if (target >= A[head] && target <= A[mid]) {
          tail = mid - 1;
        } else {
          head = mid + 1;
        }
      } else {
        if (target >= A[mid] && target <= A[tail]) {
          head = mid + 1;
        } else {
          tail = mid - 1;
        }
      }
    }

    return -1;
  }


  public static void main(String[] args) {

    SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
    int[] A = { 7, 8, 1, 2, 3, 4, 5, 6 };
    // System.out.println(searchInRotatedSortedArray.search2(A, 1));
    for (int a : A) {
      System.out.println(searchInRotatedSortedArray.search(A, a));
    }
  }
}
