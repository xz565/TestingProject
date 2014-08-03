package lcoj.search.binary;

// There are two sorted arrays A and B of size m and n respectively.
// Find the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
public class MedianofTwoSortedArrays {

  // Obviously, this question should leverage binary search technique
  // 举个栗子
  // A [1,3,5,7,8,12,23]
  // B [4,6,7,8,13,34]
  //
  // This problem can be converted to: find the K-th element in two sorted array

  // This one is so hard and tricky for me
  // and impossible to come with my own solution
  // Simply understand and remember the solution

  // Not easy to get the idea to solve it
  // Even if you got the idea, still hard to implement it correctly
  // one of the hardest problem in Leetcode
  public double findMedianSortedArrays(int A[], int B[]) {

    int M = A.length;
    int N = B.length;

    if ((M + N) % 2 == 0) {
      return (helper(A, 0, M - 1, B, 0, N - 1, (M + N) / 2) + helper(A, 0, M - 1, B, 0, N - 1, (M + N) / 2 + 1)) / 2;
    } else {
      return helper(A, 0, M - 1, B, 0, N - 1, (M + N) / 2 + 1);
    }
  }


  // To keep consistent, everything should be index
  // K is INDEX
  private double helper(int[] A, int aHead, int aTail, int[] B, int bHead, int bTail, int K) {

    int aLen = aTail - aHead + 1;
    int bLen = bTail - bHead + 1;

    // assume A is shorter than B
    // this will reduce half cases
    if (aLen > bLen) {
      return helper(B, bHead, bTail, A, aHead, aTail, K);
    }

    if (aHead > aTail) {
      return B[bHead + K - 1];
    }
    if (bHead > bTail) {
      return A[aHead + K - 1];
    }
    if (K == 1) {
      return Math.min(A[aHead], B[bHead]);
    }

    // SMART !!!
    // this ensures the parts that we keep have at least K element
    // in other word, what we delete later won't contain the Median!!!
    int aMid = Math.min(aLen, K / 2);
    int bMid = K - aMid;

    if (A[aHead + aMid - 1] < B[bHead + bMid - 1]) {

      return helper(A, aHead + aMid, aTail, B, bHead, bTail, K - aMid);

    } else if (A[aHead + aMid - 1] > B[bHead + bMid - 1]) {

      return helper(A, aHead, aTail, B, bHead + bMid, bTail, K - bMid);

    } else {

      return A[aHead + aMid - 1];
    }
  }


  public static void main(String[] args) {

    int[] A = { 1, 3 };
    int[] B = { 1, 2 };

    MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
    System.out.println(medianofTwoSortedArrays.findMedianSortedArrays(A, B));
  }
}
