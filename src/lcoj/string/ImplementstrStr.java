package lcoj.string;

// Implement strStr().
//
// Returns a pointer to the first occurrence of needle in haystack,
// or null if needle is not part of haystack.
public class ImplementstrStr {

  // BF solution
  // O(M*N) too expensive
  // but still got ACed
  public String strStr_BAD(String haystack, String needle) {

    if (haystack.length() < needle.length()) {
      return null;
    }
    if (needle.isEmpty()) {
      return haystack;
    }

    // here used a little pruning trick to get ACed
    int i;
    outer: for (i = 0 ; i <= haystack.length() - needle.length() ; i++) {
      int iTemp = i;
      for (int j = 0 ; j < needle.length() ; j++) {
        if (iTemp < haystack.length() && needle.charAt(j) == haystack.charAt(iTemp)) {
          iTemp++;
        } else {
          break;
        }

        if (j == needle.length() - 1) {
          // return needle;
          break outer;
        }
      }
    }

    if (i > haystack.length() - needle.length()) {
      return null;
    }
    return haystack.substring(i);
  }

  // better implementation
  public String strStr(String haystack, String needle) {
      if(haystack == null || needle == null) {
          return null;
      } else if(needle.length() == 0) {
          return haystack;
      }
      
      for(int haystackIdx = 0; haystackIdx <= haystack.length() - needle.length(); haystackIdx++) {
          for(int needleIdx = 0; needleIdx < needle.length(); needleIdx++) {
              if(haystack.charAt(haystackIdx + needleIdx) != needle.charAt(needleIdx)) {
                  break;
              }
              if(needleIdx == needle.length() - 1) {
                  return haystack.substring(haystackIdx);
              }
          }
      }
      
      return null;
  }

  // Most optimized algorithm is the KMP algorithm, but too complex to implement
  // another liner algorithm is called liner hash
  //
  // This question is actually the whole Chapter 32 of Introduction to Algorithm
  // Find some time to read

  public static void main(String[] args) {

    ImplementstrStr impl = new ImplementstrStr();

    String haystack = "BBC ABCDAB ABCDABCDABDE";
    String needle = "ABCDABD";
    // System.out.println(impl.strStr_TLE(haystack, needle));

    haystack = "mississippi";
    needle = "issipi";
    System.out.println(impl.strStr_BAD(haystack, needle));
  }
}
