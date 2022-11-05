package Q237_DelNodeItself;

import ListNode.ListNode;

public class DelItself {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
