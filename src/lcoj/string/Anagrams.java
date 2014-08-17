package lcoj.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given an array of strings, return all groups of strings that are anagrams.
//
// Note: All inputs will be in lower-case.
public class Anagrams {

  public List<String> anagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<String, List<String>>();

    for (String str : strs) {

      char[] charArr = str.toCharArray();
      Arrays.sort(charArr);
      String sortedStr = new String(charArr);

      List<String> values = map.get(sortedStr);
      if (values == null) {
        values = new ArrayList<String>();
        map.put(sortedStr, values);
      }
      values.add(str);
    }

    List<String> rst = new ArrayList<String>();
    for (String key : map.keySet()) {
      List<String> values = map.get(key);
      if (values.size() > 1) {
        rst.addAll(values);
      }
    }

    return rst;
  }
}
