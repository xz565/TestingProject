package lcoj.string;

// Implement strStr().
//
// Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
public class ImplementstrStr {

  // BF solution
  public String strStr(String haystack, String needle) {

    if (haystack.length() < needle.length()) {
      return null;
    }

    for (int i = 0 ; i < haystack.length() ; i++) {
      int iTemp = i;
      for (int j = 0 ; j < needle.length() ; j++) {
        if (iTemp < haystack.length() && needle.charAt(j) == haystack.charAt(iTemp)) {
          iTemp++;
        } else {
          break;
        }

        if (j == needle.length() - 1) {
          return needle;
        }
      }
    }

    return null;
  }


  public static void main(String[] args) {

    String haystack = "BBC ABCDAB ABCDABCDABDE";
    String needle = "ABCDABD";
    ImplementstrStr impl = new ImplementstrStr();
    System.out.println(impl.strStr(haystack, needle));
  }
}
