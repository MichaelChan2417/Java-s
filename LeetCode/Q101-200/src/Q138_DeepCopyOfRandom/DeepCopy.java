package Q138_DeepCopyOfRandom;

import Node.Node;

public class DeepCopy {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node nxt;

        // insert with the next node now
        while (cur != null) {
            nxt = cur.next;
            Node insertNode = new Node(cur.val);
            // make insert
            cur.next = insertNode;
            insertNode.next = nxt;

            cur = nxt;
        }

        // fit the random
        cur = head;
        while (cur != null) {
            Node insertNext = cur.next;
            Node randomTarget = cur.random;
            if (randomTarget != null) {
                insertNext.random = randomTarget.next;
            }
            cur = insertNext.next;
        }

        // make detatched
        cur = head;
        Node newHead = cur.next;
        while (cur != null) {
            Node newNode = cur.next;
            Node NextNode = newNode.next;
            if (NextNode == null) {
                cur.next = NextNode;
                break;
            }
            newNode.next = NextNode.next;
            cur.next = NextNode;
            cur = NextNode;
        }

        return newHead;
    }
}
