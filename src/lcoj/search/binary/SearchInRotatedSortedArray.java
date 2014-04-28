package lcoj.search.binary;

import com.sun.accessibility.internal.resources.accessibility;

// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.
public class SearchInRotatedSortedArray {

  // wrong thought, good to keep
  public int search_wrong(int[] A, int target) {

	  int head = 0;
	  int tail = A.length - 1;
	  int mid;
	  
	  while(head <= tail) {
		  mid = (head + tail) /2;
		  if(target < A[mid]) {
			  if(mid+1 < A.length && A[mid + 1] < A[mid] && A[tail] >= target) {
				  head = mid + 1;
			  } else {
				  tail = mid - 1;
			  }
		  } else if(target > A[mid]) {
			  if(mid-1 >=0 && A[mid - 1] > A[mid] && A[head] <= target) {
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
  
  public int search(int[] A, int target) {
	  
	  int head = 0;
	  int tail = A.length - 1;
	  int mid = 0;
	  
	  while(head <= tail) {
		  mid = head + (tail - head) / 2;
		  if(target < A[mid]) {
			  if(target >= A[head]) {
				  tail = mid - 1;
			  } else {
				  head = mid + 1;
			  }
		  } else if(target > A[mid]) {
			  if(target <= A[tail]) {
				  head = mid + 1;
			  } else {
				  tail = mid - 1;
			  }
		  } else {
			  return mid;
		  }
	  }
	  
	  return -1;
  }


  public static void main(String[] args) {

    SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
    int[] A = {3,4,5,6,1,2};
    System.out.println(searchInRotatedSortedArray.search(A, 3));
  }
}
