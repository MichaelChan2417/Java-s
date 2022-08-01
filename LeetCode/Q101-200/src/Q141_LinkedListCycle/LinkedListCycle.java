package Q141_LinkedListCycle;

import ListNode.ListNode;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if(head==null || head.next == null){
            return false;
        }
        do {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == null || fast.next == null){
                return false;
            }
        }while(slow != fast);

        return true;
    }

    public static void main(String[] args) {

    }
}
