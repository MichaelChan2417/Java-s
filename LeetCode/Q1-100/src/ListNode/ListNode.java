package ListNode;

public class ListNode {
    public int val;
    public ListNode next = null;

    // Constructors
    public ListNode() {}

    public ListNode(int n){
        this.val = n;
    }

    public ListNode(int n, ListNode next){
        this.val = n;
        this.next = next;
    }

}
