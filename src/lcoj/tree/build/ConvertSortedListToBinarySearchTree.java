package lcoj.tree.build;

import lcoj.common.ListNode;
import lcoj.common.TreeNode;

// Given a singly linked list where elements are sorted in ascending order,
// convert it to a height balanced BST.

// The thing here is that for a given list, there might be multiple forms of balanced BST
public class ConvertSortedListToBinarySearchTree {

  // Things become a little tricky when we are given a list instead of an array
  // we don't have random access to the elements, so the top to down solution is not working

  // Then think from another perspective, a bottom up solution may apply
  // check the code

  // the use of the static variable is important

  static ListNode h;


  public TreeNode sortedListToBST(ListNode head) {

    h = head;
    int len = getLen(head);
    TreeNode root = bottomUp(0, len - 1);
    return root;
  }


  private TreeNode bottomUp(int left, int right) {

    if (left > right) {
      return null;
    }

    int mid = (left + right) / 2;

    TreeNode leftChild = bottomUp(left, mid - 1);
    TreeNode root = new TreeNode(h.val);
    h = h.next;
    TreeNode rightChild = bottomUp(mid + 1, right);

    root.left = leftChild;
    root.right = rightChild;

    return root;
  }


  private int getLen(ListNode head) {

    int len = 0;
    while (head != null) {
      head = head.next;
      len++;
    }

    return len;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
    System.out.println(convertSortedListToBinarySearchTree.sortedListToBST(head));
  }
}
