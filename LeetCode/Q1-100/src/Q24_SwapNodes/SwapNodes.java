package Q24_SwapNodes;

import ListNode.ListNode;

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1, head);

        ListNode p1, p2;
        ListNode cur = dummy;

        while(cur.next!=null && cur.next.next!=null){
            p1 = cur.next;
            p2 = cur.next.next;
            ListNode next = p2.next;

            cur.next = p2;
            p2.next = p1;
            p1.next = next;

            cur = p1;
        }

        return dummy.next;
    }
}
