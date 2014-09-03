package lcoj.math;

// Implement int sqrt(int x).
//
// Compute and return the square root of x.
public class SqrtX {

  // since the return type is int
  // so a simple binary search will work

  // remember that the sqrt of an number must less than its half
  // How can I forget this !!!

  // a few details need to notice
  public int sqrt(int x) {

    long i = 0;
    // why increased by one ???
    // think if x is 1, x/2 = 0, so need to add one.
    long j = x / 2 + 1;

    while (i <= j) {
      long mid = (i + j) / 2;
      long midSq = mid * mid;
      if (midSq == x) {
        return (int) mid;
      } else if (x < midSq) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }

    // why j ???
    System.out.println("i = " + i + " j = " + j);
    return (int) j;
  }


  // Another solution is by applying Newton's method

  // There is another constant solution with bit manipulation, definitely need to learn later !

  public static void main(String[] args) {

    SqrtX sqrtX = new SqrtX();
    System.out.println(sqrtX.sqrt(1));
    System.out.println(sqrtX.sqrt(2));
    // System.out.println(sqrtX.sqrt(3));
    // System.out.println(sqrtX.sqrt(4));
    // System.out.println(sqrtX.sqrt(5));
    // System.out.println(sqrtX.sqrt(6));
    // System.out.println(sqrtX.sqrt(7));
    // System.out.println(sqrtX.sqrt(8));
    // System.out.println(sqrtX.sqrt(9));
    // System.out.println(sqrtX.sqrt(10));
    // System.out.println(sqrtX.sqrt(11));
    // System.out.println(sqrtX.sqrt(12));
    // System.out.println(sqrtX.sqrt(13));
    // System.out.println(sqrtX.sqrt(14));
    // System.out.println(sqrtX.sqrt(15));
    // System.out.println(sqrtX.sqrt(16));

    // System.out.println(sqrtX.sqrt(2147395599));
  }
}
