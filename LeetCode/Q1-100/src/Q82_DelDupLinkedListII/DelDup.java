package Q82_DelDupLinkedListII;

import ListNode.ListNode;

public class DelDup {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next == null) return head;
        ListNode firstSingle = null;
        ListNode cur = head;
        ListNode ansNext = firstSingle;
        ListNode trv;

        while (cur != null) {
            trv = cur.next;

            if (trv != null && trv.val == cur.val) {
                while (trv != null && trv.val == cur.val) {
                    trv = trv.next;
                }
                if (trv == null && ansNext != null) {
                    ansNext.next = null;
                }
            }
            else {
                if (firstSingle == null) {
                    firstSingle = cur;
                    ansNext = firstSingle;
                }
                else {
                    ansNext.next = cur;
                    ansNext = cur;
                }
            }
            cur = trv;
        }

        return firstSingle;
    }
}
