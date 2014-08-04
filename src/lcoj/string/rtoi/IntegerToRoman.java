package lcoj.string.rtoi;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Xiaodong Zhang
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
    	
    	Map<Integer, String> map = new LinkedHashMap<Integer, String>();
    	map.put(1000, "M");
    	map.put(900, "CM");
    	map.put(500, "D");
    	map.put(400, "CD");
    	map.put(100, "C");
    	map.put(90, "XC");
    	map.put(50, "L");
    	map.put(40, "XL");
    	map.put(10, "X");
    	map.put(9, "IX");
    	map.put(5, "V");
    	map.put(4, "IV");
    	map.put(1, "I");
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(num > 0) {
    		for(int base : map.keySet()) {
    			if(num >= base) {
    				num -= base;
    				sb.append(map.get(base));
    				break;
    			}
    		}
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		IntegerToRoman itor = new IntegerToRoman();
		System.out.println(itor.intToRoman(934));
	}
}
