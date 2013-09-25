package lcoj;

public class DivideTwoIntegers {

	public static int solution(int dividend, int divisor) {
		
		if(divisor == 0)
			return -1;
		
		if(dividend == 0 || dividend < divisor)
			return 0;
		
		int b2 = divisor;
		int s = 1;
		
		while(dividend >= b2) {
			b2 = b2 << 1;
			s *= 2;
		}
		s /= 2;
		s += solution(dividend - (b2 >> 1), divisor);
		
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(23, 4));
	}
}
