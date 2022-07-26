package Q328_OddEvenLinkedList;

import ListNode.ListNode;

import java.util.List;

public class OddEvenList {

    public static ListNode oddEvenList(ListNode head){
        ListNode p = new ListNode(-1, head);
        if(head == null) return head;
        ListNode otail = head;
        ListNode otail_p = head;
        ListNode etail_p = head.next;
        ListNode ehead = head.next;
        ListNode etail = head.next;
        if(ehead == null) return head;

        otail = etail.next;
        while(otail != null && etail_p!=null){
            otail_p.next = otail;
            etail = otail.next;
            otail.next = ehead;
            etail_p.next = etail;

            // update
            etail_p = etail;
            otail_p = otail;
            if(etail != null) {
                otail = etail.next;
            }
        }

        return p.next;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode a = h;
        ListNode p = h;

        h.next = new ListNode(2);
        h = h.next;
        h.next = new ListNode(3);
        h = h.next;
        h.next = new ListNode(4);
        h = h.next;
        h.next = new ListNode(5);
        h = h.next;
//        h.next = new ListNode(6);
//        h = h.next;

        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();

        p = oddEvenList(a);
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();

    }

}
