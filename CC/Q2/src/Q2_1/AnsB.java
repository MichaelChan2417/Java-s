package Q2_1;

import Node.Node;

/**
 * If we are not using extra space, we should double scan
 */

public class AnsB {
    public Node removeRepNode(Node head){
        Node phead = new Node();
        phead.next = head;

        Node cur = head;
        while (cur != null) {
            int curVal = cur.data;
            Node locP = cur;
            Node locC = cur.next;
            while (locC != null) {
                if (locC.data == curVal) {
                    locP.next = locC.next;
                    locC = locC.next;
                    continue;
                }
                locP = locC;
                locC = locC.next;
            }

            cur = cur.next;
        }

        return phead.next;
    }
}
