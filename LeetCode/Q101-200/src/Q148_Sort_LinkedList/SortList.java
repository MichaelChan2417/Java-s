package Q148_Sort_LinkedList;

import ListNode.ListNode;

public class SortList {
    //Given the head of a linked list, return the list after sorting it in ascending order.

    public static ListNode sortList(ListNode head){
        int l = 0;  // get the length first
        ListNode p = new ListNode(-1, head);
        ListNode h1, h2, prev, cur, holder;

        while(head != null){
            l++;
            head = head.next;
        }

        for(int step=1; step<l; step*=2){
            prev = p; cur = p.next;

            while(cur != null){
                h1 = cur;  // first sub-list head
                for(int i=1; i<step && cur.next!=null; i++){
                    cur = cur.next;
                }
                h2 = cur.next;  // second sub-list head
                cur.next = null;  // cutoff 1st sub-list
                cur = h2;
                for(int i=1; i<step && cur!=null && cur.next!=null; i++){
                    cur = cur.next;
                }
                holder = null;
                if(cur != null){
                    holder = cur.next;
                    cur.next = null;  // cutoff 2nm sub-list, however, need check
                }

                prev.next = merge(h1, h2);
                while(prev.next != null){
                    prev = prev.next;
                }
                cur = holder;
            }

        }

        return p.next;
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp=dummy, t1=l1, t2=l2;

        while(t1!=null && t2!=null){
            if(t1.val < t2.val){
                temp.next = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        if(t1 != null){
            temp.next = t1;
        }else if(t2 != null){
            temp.next = t2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode h = new ListNode(5);
        ListNode p = h;

        h.next = new ListNode(3);
        h = h.next;
        h.next = new ListNode(4);
        h = h.next;
        h.next = new ListNode(1);
        h = h.next;
        h.next = new ListNode(7);
        h = h.next;
        h.next = new ListNode(2);
        h = h.next;

        p = sortList(p);

        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }

    }

}
