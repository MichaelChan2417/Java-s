package Q86_PartitionLinkedList;

import ListNode.ListNode;

/**
 * This is my modified version with 3 parts (<, = , >); the question asked us to partition in two parts (< and >=)
 */
public class Q86_PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode LH = null, LT = null;
        ListNode MH = null, MT = null;
        ListNode RH = null, RT = null;

        ListNode cur = head;
        // 3 parts set
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            // insert on left part
            if (cur.val < x) {
                if (LH == null) {
                    LH = cur;
                    LT = cur;
                }
                else {
                    LT.next = cur;
                    LT = LT.next;
                }
            }
            // insert on mid part
            else if (cur.val == x) {
                if (MH == null) {
                    MH = cur;
                    MT = cur;
                }
                else {
                    MT.next = cur;
                    MT = MT.next;
                }
            }
            // insert on right part
            else {
                if (RH == null) {
                    RH = cur;
                    RT = cur;
                }
                else {
                    RT.next = cur;
                    RT = RT.next;
                }
            }
            cur = next;
        }
        // 3 parts concat
        ListNode ans = LH;
        if (LH == null) {
            ans = MH;
            if (MH == null) {
                ans = RH;
                return ans;
            }
            else {
                MT.next = RH;
                return MH;
            }
        }
        else {
            if (MH == null) {
                LH.next = RH;
                return LH;
            }
            else {
                LT.next = MH;
                MT.next = RH;
                return LH;
            }
        }
    }
}

class PartitionII{
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode FH = null, FT = null;
        ListNode SH = null, ST = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;

            if (cur.val < x) {
                if (FH == null) {
                    FH = cur;
                }
                else {
                    FT.next = cur;
                }
                FT = cur;
            }
            else {
                if (SH == null) {
                    SH = cur;
                }
                else {
                    ST.next = cur;
                }
                ST = cur;
            }

            cur = next;
        }

        if (FH == null) {
            return SH;
        }
        else {
            FT.next = SH;
            return FH;
        }
    }
}
