package Q369_AddOneToLinkedList;

import ListNode.ListNode;

public class AddOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode tail = reverse(head);

        int carry = 1;
        ListNode cur = tail;

        while(carry != 0 && cur.next != null){
            int value = cur.val + carry;
            carry = value / 10;
            value = value % 10;
            cur.val = value;
            cur = cur.next;
        }

        // add new node?
        if(cur.next == null){
            int value = cur.val + carry;
            carry = value / 10;
            value = value % 10;
            cur.val = value;

            if(carry == 1){
                cur.next = new ListNode(1);
                cur = cur.next;
            }
        }

        while(cur.next != null){
            cur = cur.next;
        }

        ListNode nh = reverse(tail);

        return nh;
    }

    ListNode reverse(ListNode head){
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
