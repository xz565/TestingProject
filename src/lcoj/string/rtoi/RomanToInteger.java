package lcoj.string.rtoi;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static int romanToIntBest(String s) {
        int i, total, pre, cur;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
        total = map.get(s.charAt(0));

        for (i = 1; i < s.length(); i++) {
            pre = map.get(s.charAt(i - 1));
            cur = map.get(s.charAt(i));

            if (cur <= pre) {
                total += cur;
            } else {
                total = total - pre * 2 + cur;
            }
        }

        return total;
    }
	
	public int romanToInt(String s) {
		int sum = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int i;
		for(i = 0; i < s.length() - 1; i++) {
			char curt = s.charAt(i);
			char next = s.charAt(i + 1);
			
			int curtVal = map.get(curt);
			int nextVal = map.get(next);
			
			if(curtVal < nextVal) {
				sum += (nextVal - curtVal);
				i++;
			} else {
				sum += curtVal;
			}
		}
		
		if(i == s.length() - 1) {
			sum += map.get(s.charAt(s.length() - 1));
		}
		return sum;
	}
	
	// Ugly...
	public int romanToIntBad(String s) {

		int sum = 0;
		int i;
		for (i = 0; i < s.length() - 1; i++) {

			char curt = s.charAt(i);
			char next = s.charAt(i + 1);
			
			if(curt == 'I') {
				if(next == 'V') {
					sum += 4;
					i++;
				} else if(next == 'X') {
					sum += 9;
					i++;
				} else {
					sum += 1;
				}
			} else if (curt == 'V') {
				sum += 5;
			} else if(curt == 'X') {
				if(next == 'L') {
					sum += 40;
					i++;
				} else if(next == 'C') {
					sum += 90;
					i++;
				} else {
					sum += 10;
				}
			} else if(curt == 'L') {
				sum += 50;
			} else if(curt == 'C') {
				if(next == 'D') {
					sum += 400;
					i++;
				} else if(next == 'M') {
					sum += 900;
					i++;
				} else {
					sum += 100;
				}
			} else if(curt == 'D') {
				sum += 500;
			} else if(curt == 'M') {
				sum += 1000;
			}
		}
		
		if(i == s.length() - 1) {
			char last = s.charAt(i);
			if(last == 'I') {
				sum += 1;
			} else if (last == 'V') {
				sum += 5;
			} else if (last == 'X') {
				sum += 10;
			} else if (last == 'L') {
				sum += 50;
			} else if (last == 'C') {
				sum += 100;
			} else if (last == 'D') {
				sum += 500;
			} else if (last == 'M') {
				sum += 1000;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		RomanToInteger rtoi = new RomanToInteger();
		System.out.println(rtoi.romanToInt("XLVIII"));
	}
}
