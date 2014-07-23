package lcoj.string;

import java.util.ArrayList;

// Given an absolute path for a file (Unix-style), simplify it.
//
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
public class SimplifyPath {

  // thought is simple, use a stack storing all the element
  // then process them one by one
  // hard part maybe the corner cases, need to pass
  public String simplifyPath(String path) {

    if (path == null || path.isEmpty()) {
      return "";
    }
    if ("/".equals(path)) {
      return path;
    }

    String[] paths = path.split("/");
    ArrayList<String> list = new ArrayList<String>();
    for (String str : paths) {
      if (!str.isEmpty()) {
        if (".".equals(str)) {
          continue;
        } else if ("..".equals(str)) {
          if (list.size() > 0) {
            list.remove(list.size() - 1);
          }
        } else {
          list.add(str);
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    if (list.isEmpty()) {
      return "/";
    }
    for (String str : list) {
      sb.append("/").append(str);
    }
    return sb.toString();
  }


  public static void main(String[] args) {

    SimplifyPath simplifyPath = new SimplifyPath();

    String path = "/a/./b/../../c/";
    System.out.println(simplifyPath.simplifyPath(path));

    path = "/home/";
    System.out.println(simplifyPath.simplifyPath(path));

    path = "/../";
    System.out.println(simplifyPath.simplifyPath(path));
  }
}
