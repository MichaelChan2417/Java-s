package Q23_MergeKSortedList;

import ListNode.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeKSortedList {
    Queue<ListNode> q = new LinkedList<>();

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        for(ListNode head : lists){
            q.offer(head);
        }

        while(q.size() > 1){
            ListNode head1 = q.poll();
            ListNode head2 = q.poll();

            ListNode ret = merge(head1, head2);
            q.offer(ret);
        }

        return q.poll();
    }

    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode();

        ListNode cur = dummy;
        ListNode l1 = h1, l2 = h2;

        while(l1 != null && l2 != null){

            if(l1.val == l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;

                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
                continue;
            }

            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                continue;
            }
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }

        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }

        return dummy.next;
    }
}
