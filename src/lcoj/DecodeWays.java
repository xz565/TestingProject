package lcoj;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public static int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		if (s == null) {
			return -1;
		}

		if(s.isEmpty())
			return 0;
		
		if(s.length() == 1)
			return 1;
		
		if(s.length() == 2) {
			if(Integer.parseInt(s) <= 24 && Integer.parseInt(s) > 0) {
				return 2;
			} else {
				return 1;
			}
		}
		
		int first = numDecodings(s.substring(1));
		int second = 1;
		
		if(Integer.parseInt(s.substring(0, 2)) <= 24 && Integer.parseInt(s) > 0) {
			second = numDecodings(s.substring(2));
		}
		
		map.put(s, first + second);
		
		return first + second;
	}
	
}
