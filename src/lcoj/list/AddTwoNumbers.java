package lcoj.list;

import lcoj.common.ListNode;

// You are given two linked lists representing two non-negative numbers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(0);

    ListNode curt1 = l1, curt2 = l2, head = result;
    int carry = 0;

    while (curt1 != null || curt2 != null) {
      if (curt1 != null) {
        carry += curt1.val;
        curt1 = curt1.next;
      }
      if (curt2 != null) {
        carry += curt2.val;
        curt2 = curt2.next;
      }
      result.next = new ListNode(carry % 10);
      result = result.next;
      carry /= 10;
    }

    if (carry == 1) {
      result.next = new ListNode(1);
    }
    return head.next;
  }


  public static void main(String[] args) {

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode l1 = new ListNode(0);
    // l1.next = new ListNode(4);
    // l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(7);
    l2.next = new ListNode(3);
    // l2.next.next = new ListNode(4);

    System.out.println(ListNode.printListNode(addTwoNumbers.addTwoNumbers(l1, l2)));
  }
}
