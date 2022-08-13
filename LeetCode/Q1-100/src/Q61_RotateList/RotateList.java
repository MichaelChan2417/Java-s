package Q61_RotateList;

import ListNode.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode cur = head;
        int n = 0;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        k = k % n;
        if(k == 0) return head;

        ListNode fast = head;
        for(int i=0; i<k; i++){
            fast = fast.next;
        }

        cur = head;
        while(fast.next != null){
            fast = fast.next;
            cur = cur.next;
        }
        ListNode secondHead = cur.next;

        cur.next = null;
        fast.next = head;

        return secondHead;
    }
}
