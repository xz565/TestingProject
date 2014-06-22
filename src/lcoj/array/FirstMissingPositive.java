package lcoj.array;

// Given an unsorted integer array, find the first missing positive integer.
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
// Your algorithm should run in O(n) time and uses constant space.
public class FirstMissingPositive {

  // 常数空间的话，第一可以考虑是不是固定数量的几个变量能搞定；
  // 否则可以考虑是不是问题本身已经提供了足够的空间。
  // use the array itself and index of the array
  // index i should store i+1

  // also need to consider duplicate situation
  public int firstMissingPositive(int[] A) {

    for (int i = 0 ; i < A.length ;) {
      if (A[i] != i + 1 && A[i] < A.length && A[i] > 0) {
        // deal with duplicate elements
        if (A[i] == A[A[i] - 1]) {
          i++;
          continue;
        }
        // swap A[i] and A[A[i]-1]
        int temp = A[i];
        A[i] = A[temp - 1];
        A[temp - 1] = temp;
      } else {
        i++;
      }
    }

    for (int i = 0 ; i < A.length ; i++) {
      if (A[i] != i + 1) {
        return i + 1;
      }
    }

    // cannot simply return 0 or 1
    // return 0
    return A.length + 1;
  }


  // This problem has lots of good test cases
  public static void main(String[] args) {

    // swap 3 and -1
    // i = 0; A[i] = 3;
    int[] A = { 3, 4, -1, 1 };
    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
    System.out.println(firstMissingPositive.firstMissingPositive(A));
    int[] B = { 1, 1 };
    System.out.println(firstMissingPositive.firstMissingPositive(B));
    int[] C = {};
    System.out.println(firstMissingPositive.firstMissingPositive(C));
    int[] D = { 1 };
    System.out.println(firstMissingPositive.firstMissingPositive(D));
  }
}
