package Q25_ReverseNodeInK_Group;

import ListNode.ListNode;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseKGroup {
    Queue<ListNode> q = new LinkedList<ListNode>();

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode prevhead = head;

        ListNode cur = head;
        while(cur != null){
            for(int i=0; i<k-1 && cur!=null; i++){
                cur = cur.next;
            }
            if(cur == null) break;

            ListNode temphead = cur.next;
            cur.next = null;  // break the chain

            ListNode backhead = reverse(prevhead);
            q.offer(backhead);

            prevhead = temphead;
            cur = temphead;
        }

        // if accidentally break, prevhead would store the now head;
        ListNode trv = dummy;
        while(!q.isEmpty()){
            ListNode backnode = q.poll();
            trv.next = backnode;
            while(trv.next != null){
                trv = trv.next;
            }
        }
        trv.next = prevhead;
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
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
