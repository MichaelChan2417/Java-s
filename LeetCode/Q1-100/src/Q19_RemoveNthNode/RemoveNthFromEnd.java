package Q19_RemoveNthNode;

import ListNode.ListNode;

import java.util.Stack;


public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0) return head;
        ListNode P = new ListNode();
        P.next = head;

        // the pre-walker
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // the follower
        ListNode follower = P;

        while(first != null){
            first = first.next;
            follower = follower.next;
        }

        ListNode next = new ListNode();
        next = follower.next.next;

        follower.next = next;

        return P.next;
    }

    public static void main(String[] args) {

    }

}
