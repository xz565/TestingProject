package lcoj.tree.traversal.level;

import lcoj.common.TreeLinkNode;

// Follow up for problem "Populating Next Right Pointers in Each Node".
//
// What if the given tree could be any binary tree? Would your previous solution still work?
//
// Note:
//
// You may only use constant extra space.
// For example,
// Given the following binary tree,
// 1
// / \
// 2 3
// / \ \
// 4 5 7
// After calling your function, the tree should look like:
// 1 -> NULL
// / \
// 2 -> 3 -> NULL
// / \ \
// 4-> 5 -> 7 -> NULL
public class PopulatingNextRightPointersInEachNodeII {

  public void connect_wrong(TreeLinkNode root) {

    if (root == null) {
      return;
    }

    if (root.left != null) {
      if (root.right != null) {
        root.left.next = root.right;
      } else if (root.next != null) {
        root.left.next = findFirstChildOfNext(root.next);
      }
    }

    if (root.right != null) {
      root.right.next = findFirstChildOfNext(root.next);
    }

    // this is not constant space
    connect_wrong(root.left);
    connect_wrong(root.right);
  }


  private TreeLinkNode findFirstChildOfNext(TreeLinkNode next) {

    TreeLinkNode nextTmp = next;
    while (nextTmp != null) {
      if (nextTmp.left != null) {
        return nextTmp.left;
      } else if (nextTmp.right != null) {
        return nextTmp.right;
      } else {
        nextTmp = nextTmp.next;
      }
    }
    return null;
  }


  // in the very essence, this is level by level traverse
  // because of the next point we have, we can get rid
  // of the stack to keep track node in one level, and utilize
  // the next pointer to get next node in one level
  public void connect(TreeLinkNode root) {

    TreeLinkNode parent = root;
    TreeLinkNode child = null;
    TreeLinkNode firstChild = null;

    while (parent != null) {

      if (parent.left != null) {
        if (child == null) {
          child = parent.left;
          firstChild = child;
        } else {
          child.next = parent.left;
          child = child.next;
        }
      }

      if (parent.right != null) {
        if (child == null) {
          child = parent.right;
          firstChild = child;
        } else {
          child.next = parent.right;
          child = child.next;
        }

      }

      parent = parent.next;
      if (parent == null) {
        parent = firstChild;
        child = null;
        firstChild = null;
      }
    }
  }


  public static void main(String[] args) {

    TreeLinkNode root = new TreeLinkNode(2);
    root.left = new TreeLinkNode(1);
    root.right = new TreeLinkNode(3);

    root.left.left = new TreeLinkNode(0);
    root.left.right = new TreeLinkNode(7);
    root.right.left = new TreeLinkNode(9);
    root.right.right = new TreeLinkNode(1);

    root.left.left.left = new TreeLinkNode(2);
    root.left.right.left = new TreeLinkNode(1);
    root.left.right.right = new TreeLinkNode(0);
    root.right.right.left = new TreeLinkNode(8);
    root.right.right.right = new TreeLinkNode(8);

    root.left.right.right.left = new TreeLinkNode(7);

    PopulatingNextRightPointersInEachNodeII pII = new PopulatingNextRightPointersInEachNodeII();
    pII.connect(root);
    System.out.println(root);
  }
}
