package Q206_Reverse_List;

import ListNode.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while(cur != null){
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}
