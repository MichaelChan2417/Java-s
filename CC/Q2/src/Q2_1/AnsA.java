package Q2_1;

import Node.Node;

import java.util.HashSet;

/**
 * Use Hashtable to store counts
 */
public class AnsA {
    public Node removeRepNode(Node head){
        Node phead = new Node();
        phead.next = head;
        Node prev = phead;
        Node cur = head;
        HashSet<Integer> visited = new HashSet<>();

        while (cur != null) {
            if (!visited.contains(cur.data)) {
                visited.add(cur.data);
                prev = cur;
                cur = cur.next;
                continue;
            }
            prev.next = cur.next;
            cur = cur.next;
        }

        return phead.next;
    }
}

