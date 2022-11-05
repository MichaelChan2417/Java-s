package Q92_ReverseLinkedListII;

import ListNode.ListNode;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode phead = new ListNode(-1);
        phead.next = head;
        ListNode OT = phead, FH, FT, SH;

        for (int i=1; i<left; i++) {
            OT = OT.next;
        }
        FH = OT.next;
        OT.next = null;

        ListNode trv = FH;
        for (int i=left; i<right; i++) {
            trv = trv.next;
        }
        FT = trv;
        SH = trv.next;
        FT.next = null;

        ListNode nodeBack = reverse(FH);
        OT.next = nodeBack;
        trv = nodeBack;
        while (trv.next != null) {
            trv = trv.next;
        }
        trv.next = SH;

        return phead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt;

        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
