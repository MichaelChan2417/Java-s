package Q83_DelRepNode;

import ListNode.ListNode;

public class DelRep {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = head;

        ListNode cur = head;
        ListNode trv;
        while (cur != null) {
            trv = cur.next;
            while (trv != null && trv.val == cur.val) {
                trv = trv.next;
            }
            cur.next = trv;
            cur = trv;
        }

        return phead;
    }
}
