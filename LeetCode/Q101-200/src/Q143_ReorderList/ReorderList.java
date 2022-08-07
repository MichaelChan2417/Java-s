package Q143_ReorderList;

import ListNode.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {

        if(head.next == null) return;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        // now I need to reverse the second linked-list
        ListNode prev = null;
        ListNode cur = secondHead;
        ListNode next = secondHead.next;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // now prev hold the second head;
        secondHead = prev;

        // merge
        ListNode secondNext;
        prev = dummy;
        cur = dummy.next;
        while(secondHead != null){
            next = cur.next;
            secondNext = secondHead.next;

            secondHead.next = next;
            cur.next = secondHead;

            cur = next;
            secondHead = secondNext;
        }

        head = dummy.next;
    }
}
