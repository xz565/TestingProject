package lcoj.search.binary;

// Implement pow(x, n).
public class PowXN {

  public double pow_TLE(double x, int n) {

    if (x == 0) {
      return 0;
    }

    if (n == 0) {
      return x;
    }

    double rst = 1;

    if (n > 0) {
      for (int i = 0 ; i < n ; i++) {
        rst *= x;
      }
    } else {
      for (int i = 0 ; i < -n ; i++) {
        rst *= x;
      }

      rst = 1 / rst;
    }

    return rst;
  }


  // binary search
  public double pow(double x, int n) {

    if (n >= 0) {
      return power(x, n);
    } else {
      return 1.0 / power(x, -1 * n);
    }
  }


  // positive N
  private double power(double x, int n) {

    if (n == 0) {
      return 1;
    }

    double v = power(x, n / 2);
    if (n % 2 == 0) {
      return v * v;
    } else {
      return v * v * x;
    }

  }


  public static void main(String[] args) {

    PowXN powXN = new PowXN();
    System.out.println(powXN.pow(0, 0));
    System.out.println(powXN.pow(20, 10));
    System.out.println(powXN.pow(-0.5, -2147483648));
    System.out.println(powXN.pow(0.00001, 2147483647));
  }
}
