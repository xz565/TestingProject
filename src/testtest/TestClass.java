package testtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class TestClass implements Comparable {

	public static final Logger LOGGER = Logger.getLogger(TestClass.class
			.getName());

	public static void main(String[] args) {
	  
	  Object obj = new Object();
	  String str = (String) obj;
	  
	  System.out.println(str);
	  
	  List<String> myList = new ArrayList<String>(1);
	  myList.add("aaaaaaaaaaaaaa");
	  myList.add("bbbbbbbbbbbbbb");
	  System.out.println("List size " + myList.size());

		System.out.println(LOGGER);

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		System.out.println("--------------------------------------");

		for (Iterator<Integer> key = map.keySet().iterator(); key.hasNext(); key
				.next()) {
			System.out.println(key);
			map.remove(key);
			System.out.println(map);
		}

		System.out.println("--------------------------------------");

		/*
		 * for(Integer key : map.keySet()) { map.remove(key); break; }
		 */

		for (Iterator<Entry<Integer, String>> iter = map.entrySet().iterator(); iter
				.hasNext();) {

			Entry<Integer, String> entry = iter.next();
			if (entry.getKey() == 1)
				iter.remove();

		}

		/*
		 * for (Entry<Integer, String> entry : map.entrySet()) {
		 * 
		 * if (entry.getKey() == 1 || entry.getKey() == 2) map.remove(entry); }
		 */

		System.out.println(map);

		List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);

		System.out.println(list);
	}

	@Override
	public int compareTo(Object o) {

		// TODO Auto-generated method stub
		return 0;
	}
}
