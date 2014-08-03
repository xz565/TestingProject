package lcoj.common;

public class ListNode {

  public int val;
  public ListNode next;


  public ListNode(int x) {

    val = x;
    next = null;
  }


  @Override
  public String toString() {

    return "ListNode [val=" + val + ", next=" + next + "]";
  }


  public static String printListNode(ListNode head) {

    StringBuffer sb = new StringBuffer();
    while (head != null) {
      sb.append(head.val).append("->");
      head = head.next;
    }
    sb.append("null");
    return sb.toString();
  }

}
