package Q382_LinkedListRandomNode;

import ListNode.ListNode;

import java.util.Random;

public class RandomNode {
    ListNode head;
    Random random;

    public void Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int i = 1, ans = 0;
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) { //
                ans = node.val;
            }
            ++i;
        }
        return ans;
    }
}

