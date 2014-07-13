package lcoj.string;

import java.util.ArrayList;
import java.util.List;

// P A H N
// A P L S I I G
// Y I R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
public class ZigZagConversion {


  // this is a math question
  // the following solution can pass OJ, but not the best one
  public String convert(String s, int nRows) {

    if (nRows == 1) {
      return s;
    }

    List<List<Character>> alal = new ArrayList<List<Character>>();
    for (int i = 0 ; i < nRows ; i++) {
      alal.add(new ArrayList<Character>());
    }

    int curtRow = 0;
    boolean down = true;
    for (int i = 0 ; i < s.length() ; i++) {
      List<Character> al = alal.get(curtRow);
      al.add(s.charAt(i));

      if (down) {
        curtRow++;
        if (curtRow == nRows) {
          down = false;
          curtRow = nRows - 2;
        }
        continue;
      }

      if (!down) {
        curtRow--;
        if (curtRow == -1) {
          down = true;
          curtRow = 1;
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for (List<Character> al : alal) {
      for (Character ch : al) {
        sb.append(ch);
      }
    }

    return sb.toString();
  }


  public static void main(String[] args) {

    ZigZagConversion zigZagConversion = new ZigZagConversion();
    String s = "PAYPALISHIRING";
    int nRows = 1;
    System.out.println(zigZagConversion.convert(s, nRows));
  }
}
