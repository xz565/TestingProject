package lcoj.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lcoj.common.ListNode;

// Merge k sorted linked lists and return it as one sorted list.
// Analyze and describe its complexity.

// Time complex is O(N*lises.size())
// this is bad, and what's more, I don't find a valid implementation
public class MergeKSortedLists {

  // bad in time and wrong in implementation
  // cann't be worse
  public ListNode mergeKLists_bad(List<ListNode> lists) {

    ListNode dummy = new ListNode(0);
    ListNode head = dummy;

    if (lists == null) {
      return null;
    }

    while (lists.size() > 1) {
      ListNode min = new ListNode(Integer.MAX_VALUE);

      Iterator<ListNode> ite = lists.iterator();

      while (ite.hasNext()) {
        ListNode list = ite.next();
        if (list != null && list.val < min.val) {
          min = list;
        }
      }

      head.next = min;
      head = head.next;
      min = min.next;
    }

    if (lists.size() == 1) {
      head.next = lists.get(0);
    }

    return dummy.next;
  }


  // here we use divide and conquer
  public ListNode mergeKLists(List<ListNode> lists) {

    if (lists.size() == 0) {
      return null;
    }

    if (lists.size() == 1) {
      return lists.get(0);
    }

    List<ListNode> l1 = new ArrayList<ListNode>();
    List<ListNode> l2 = new ArrayList<ListNode>();

    for (int i = 0 ; i < lists.size() ; i++) {
      if (i < lists.size() / 2) {
        l1.add(lists.get(i));
      } else {
        l2.add(lists.get(i));
      }
    }

    ListNode head1 = mergeKLists(l1);
    ListNode head2 = mergeKLists(l2);

    ListNode head = merge(head1, head2);
    return head;
  }


  private ListNode merge(ListNode head1, ListNode head2) {

    ListNode dummy = new ListNode(0);
    ListNode head = dummy;

    while (head1 != null && head2 != null) {
      if (head1.val <= head2.val) {
        head.next = head1;
        head1 = head1.next;
      } else {
        head.next = head2;
        head2 = head2.next;
      }
      head = head.next;
    }

    if (head1 == null) {
      head.next = head2;
    } else if (head2 == null) {
      head.next = head1;
    }

    return dummy.next;
  }


  public static void main(String[] args) {

    ListNode l1 = new ListNode(0);
    // l1.next = new ListNode(2);
    ListNode l2 = new ListNode(1);

    List<ListNode> lists = new ArrayList<ListNode>();
    lists.add(l1);
    lists.add(l2);

    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
    ListNode rst = mergeKSortedLists.mergeKLists(lists);
    ListNode.printListNode(rst);
  }
}
