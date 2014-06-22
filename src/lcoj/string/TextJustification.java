package lcoj.string;

import java.util.ArrayList;
import java.util.List;

// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L
// characters.
//
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be
// assigned more spaces than the slots on the right.
//
// For the last line of text, it should be left justified and no extra space is inserted between words.
//
// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.
//
// Return the formatted lines as:
// [
// "This    is    an",
// "example  of text",
// "justification.  "
// ]
public class TextJustification {


  /** This kind of looping has its disadvantage in complex algorithm */
  // better to use a while loop
  // for (String word : words) {
  // if (sb.length() + word.length() <= L) {
  // sb.append(word).append(" ");
  // } else {
  // result.add(sb.toString());
  // sb.setLength(0);
  // sb.append(word).append(" ");
  // }
  // }

  /** This thought is sooooooo stupid */
  // int idx = 0;
  // while (idx < words.length) {
  // String word = words[idx];
  // if (sb.length() + word.length() <= L) {
  // sb.append(word).append(" ");
  // idx++;
  // } else {
  // if (sb.charAt(sb.length() - 1) == ' ') {
  // sb.deleteCharAt(sb.length() - 1);
  // }
  // int fromIndex = 0;
  // while (sb.length() < L) {
  //
  // int offset = sb.indexOf(" ", fromIndex);
  // if (offset > 0) {
  // sb.insert(offset, " ");
  // fromIndex = offset;
  // do {
  // fromIndex++;
  // } while (sb.charAt(fromIndex) == ' ');
  // } else {
  // fromIndex = 0;
  // }
  // }
  // System.out.println(sb);
  // result.add(sb.toString());
  // sb.setLength(0);
  // }
  // }
  //
  // if (sb.length() > 0) {
  // sb.deleteCharAt(sb.length() - 1);
  // result.add(sb.toString());
  // }


  // Easy in the perspective of algorithm]
  // but a lot of tricks in implementation and corner cases
  public List<String> fullJustify(String[] words, int L) {

    List<String> result = new ArrayList<String>();
    List<StringBuffer> tempList = new ArrayList<StringBuffer>();
    int tempLen = 0;

    int idx = 0;
    while (idx < words.length) {
      String word = words[idx];
      if (tempLen + tempList.size() + word.length() <= L) {
        tempList.add(new StringBuffer(word));
        tempLen += word.length();
        idx++;
      } else {

        while (tempLen < L) {
          for (int i = 0 ; i < tempList.size() ; i++) {
            if (tempList.size() > 1 && i == tempList.size() - 1) {
              continue;
            }
            StringBuffer sb = tempList.get(i);
            if (tempLen < L) {
              sb.append(" ");
              tempLen++;
            }
          }
        }
        StringBuffer resuleSb = new StringBuffer();
        for (StringBuffer sb : tempList) {
          resuleSb.append(sb);
        }

        result.add(resuleSb.toString());
        tempList.clear();
        tempLen = 0;
      }
    }

    if (!tempList.isEmpty()) {
      StringBuffer sb = new StringBuffer();
      for (StringBuffer sb2 : tempList) {
        sb.append(sb2).append(" ");
      }
      sb.deleteCharAt(sb.length() - 1);
      while (sb.length() < L) {
        sb.append(" ");
      }
      result.add(sb.toString());
    }
    return result;

  }


  public static void main(String[] args) {

    TextJustification tj = new TextJustification();

    // after failed for all the following test cases
    // finally got ACed

    String[] str = { "Listen", "to", "many,", "speak", "to", "a", "few." };
    System.out.println(tj.fullJustify(str, 6));

    String[] str2 = { "" };
    System.out.println(tj.fullJustify(str2, 2));


    String[] str3 = { "a", "b", "c", "d", "e" };
    System.out.println(tj.fullJustify(str3, 3));

    String[] str4 = { "What", "must", "be", "shall", "be." };
    System.out.println(tj.fullJustify(str4, 12));

    String[] str5 = { "" };
    System.out.println(tj.fullJustify(str5, 0));

  }
}
