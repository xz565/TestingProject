package lcoj.recursive.dfs.permutation;


// Implement next permutation, which rearranges numbers into the
// lexicographically next greater permutation of numbers.
//
// If such arrangement is not possible, it must rearrange it
// as the lowest possible order (ie, sorted in ascending order).
//
// The replacement must be in-place, do not allocate extra memory.
//
// Here are some examples. Inputs are in the left-hand column
// and its corresponding outputs are in the right-hand column.
//
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
public class NextPermutation {

  // Another math problem
  //
  // For lexicographically order, from right to left, number should goes up

  // 6 8 7 4 3 2
  // 1. from right to left, find the first digit (Partition number) which violates
  // the increase trend. it's 6
  // 2. from right to left, find the first number that is greater than partition
  // number, call is changeNumber, it's 7
  // 3. swap 6, and 7: 7 8 6 4 3 2
  // 4. reverse all digits on the right of partition index (now it's changeNumber)
  // 7 2 3 4 6 8
  // this kind of problem doesn't make too much sense
  public void nextPermutation(int[] num) {

    int partitionIdx = -1; // default as 0
    for (int i = num.length - 2 ; i >= 0 ; i--) {
      if (num[i] < num[i + 1]) {
        partitionIdx = i;
        break;
      }
    }


    if (partitionIdx >= 0) {
      for (int i = num.length - 1 ; i > partitionIdx ; i--) {
        if (num[i] > num[partitionIdx]) {

          int temp = num[i];
          num[i] = num[partitionIdx];
          num[partitionIdx] = temp;
          break;
        }
      }
    }

    int head = partitionIdx + 1;
    int tail = num.length - 1;
    while (head < tail) {
      int temp = num[head];
      num[head] = num[tail];
      num[tail] = temp;
      head++;
      tail--;
    }
  }


  public static void main(String[] args) {

    int[] num = { 1, 2, 3 };
    NextPermutation nextPermutation = new NextPermutation();
    nextPermutation.nextPermutation(num);
    for (int i : num) {
      System.out.println(i);
    }
  }
}
