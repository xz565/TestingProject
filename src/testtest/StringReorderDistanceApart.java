package testtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringReorderDistanceApart {

	public static String reorder(String str, int dist) {

		Map<Character, Integer> contentMap = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			if (contentMap.keySet().contains(c)) {
				
				contentMap.put(c, contentMap.get(c) + 1);
			} else {
			
				contentMap.put(c, 1);
			}
		}
		
		System.out.println(contentMap);

		List<Entry<Character, Integer>> entryList = new ArrayList<Entry<Character, Integer>>(
				contentMap.entrySet());

		Collections.sort(entryList, new ValueComparator());

		contentMap = new LinkedHashMap<Character, Integer>();
		
		for(Entry<Character, Integer> entry : entryList)
			contentMap.put(entry.getKey(), entry.getValue());
		
		System.out.println(contentMap);
		
		// LinkedList<Character> window = new LinkedList<Character>();

		return null;
	}

	public static void main(String[] args) {

		reorder("ddddaaaaaabbbbbccc", 2);
	}
}

class ValueComparator implements Comparator<Entry<Character, Integer>> {

	@Override
	public int compare(Entry<Character, Integer> o1,
			Entry<Character, Integer> o2) {

		return o1.getValue().compareTo(o2.getValue());
	}

}