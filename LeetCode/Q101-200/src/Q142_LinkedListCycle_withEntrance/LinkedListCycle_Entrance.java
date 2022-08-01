package Q142_LinkedListCycle_withEntrance;

import ListNode.ListNode;

public class LinkedListCycle_Entrance {

    public static ListNode detectCycle(ListNode head) {

        ListNode fast = head, slow = head;
        if(head == null || head.next == null){
            return null;
        }

        do{
            fast = fast.next.next;
            slow = slow.next;

            if(fast == null || fast.next == null) {
                return null;
            }
        }while(fast != slow);

        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
