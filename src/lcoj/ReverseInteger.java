package lcoj;

/*
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {

    public static int reverse(int x) {

	boolean neg = false;

	if (x < 0) {
	    x *= -1;
	    neg = true;
	}

	StringBuffer sb = new StringBuffer(String.valueOf(x));
	int left = 0;
	int right = sb.length() - 1;
	while (left < right) {
	    char leftChar = sb.charAt(left);
	    char rightChar = sb.charAt(right);
	    sb.setCharAt(left, rightChar);
	    sb.setCharAt(right, leftChar);
	    left++;
	    right--;
	}

	return neg ? Integer.parseInt("-" + sb.toString()) : Integer
		.parseInt(sb.toString());
    }

    public static void main(String[] args) {
	System.out.println(reverse(-4321));
    }
}
