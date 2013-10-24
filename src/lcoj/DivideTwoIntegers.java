package lcoj;

public class DivideTwoIntegers {

	public static int divide(int dividend, int divisor) {

		long dividendAbs = Math.abs((long) dividend);
		long divisorAbs = Math.abs((long) divisor);

		if (divisorAbs == 0)
			return -1;

		if (dividendAbs == 0 || dividendAbs < divisorAbs)
			return 0;

		long divisor2 = divisorAbs;
		long quotient = 1;

		while (dividendAbs >= divisor2) {
			divisor2 = divisor2 << 1;
			quotient = quotient << 1;
		}
		quotient = quotient >> 1;
		quotient += divide((int) (dividendAbs - (divisor2 >> 1)),
				(int) divisorAbs);

		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			return (int) (0L - quotient);

		return (int) quotient;
	}

	public static void main(String[] args) {
		System.out.println(divide(2147483647, 1));
	}
}
