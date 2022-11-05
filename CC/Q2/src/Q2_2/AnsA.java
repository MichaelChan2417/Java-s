package Q2_2;

import Node.Node;

public class AnsA {
    public Node deleteLastK(Node head, int k) {
        Node phead = new Node();
        phead.next = head;

        Node fast = phead;
        Node slow = phead;

        for (int i=0; i<k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        Node curNext = slow.next;
        slow.next = curNext.next;

        return phead.next;
    }
}
