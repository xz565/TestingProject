package lcoj;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	static Map<String, Integer> map = new HashMap<String, Integer>();

	public static int numDecodings(String s) {
		
		if(map.containsKey(s)) return map.get(s);
		
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		
		if (s.length() == 1) {
			return 1;
		}
		
		int fix = (s.length() == 2 ? 1 : 0);
		
		int ways;
		
		if(s.charAt(0) == '1' || (s.charAt(0) == '2' && Integer.parseInt("" + s.charAt(1)) < 7)) {
			ways = numDecodings(s.substring(1)) + numDecodings(s.substring(2)) + fix;
			map.put(s, ways);
			return ways;
		}
			
		ways = numDecodings(s.substring(1));
		map.put(s, ways);
		return ways;
	}
//	public static int numDecodings(String s) {
//		
//		if (s.isEmpty() || s.charAt(0) == '0') {
//			return 0;
//		}
//
//		return helper(s);
//		
//	}
//	
//	public static int helper(String s) {
//		
//		if (map.containsKey(s)) {
//			return map.get(s);
//		}
//		
//		if (s.length() == 0)
//			return 0;
//
//		if (s.length() == 1)
//			return 1;
//
//		if (s.length() == 2) {
//			int sValue = Integer.parseInt(s);
//			
//			if(sValue % 10 == 0 && sValue != 0)
//				return 1;
//			else {
//				if(sValue > 0 && sValue < 27)
//					return 2;
//				else if (sValue >= 27)
//					return 1;
//				else 
//					return 0;
//			}
//		}
//		
//		int firstWays = 0;
//		int firstTemp = helper(s.substring(1));
//		if(s.charAt(0) != '0' && firstTemp != 0) {
//			firstWays = firstTemp;
//		}
//		
//		int secondWays = 0;
//		int secondTemp = helper(s.substring(2));
//		if (Integer.parseInt(s.substring(0, 2)) <= 24 && Integer.parseInt(s.substring(0, 2)) > 0 && secondTemp != 0) {
//			secondWays = secondTemp;
//		}
//
//		map.put(s, firstWays + secondWays);
//
//		System.out.println(firstWays + " " + secondWays);
//		return firstWays + secondWays;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(numDecodings("100"));
//	}

}
