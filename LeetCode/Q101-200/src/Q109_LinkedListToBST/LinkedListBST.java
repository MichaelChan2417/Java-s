package Q109_LinkedListToBST;

import ListNode.ListNode;
import TreeNode.TreeNode;

public class LinkedListBST {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head);
    }

    private TreeNode buildTree(ListNode head){
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            TreeNode TNode = new TreeNode(head.val);
            return TNode;
        }

        ListNode phead = new ListNode(-1);
        phead.next = head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            phead = phead.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        // make break
        ListNode midNode = slow.next;
        ListNode rightHead = midNode.next;
        midNode.next = null;
        slow.next = null;

        TreeNode root = new TreeNode(midNode.val);
        TreeNode left = buildTree(head);
        TreeNode right = buildTree(rightHead);

        root.left = left;
        root.right = right;

        return root;
    }
}
