package Node;

public class Node {
    public Node next = null;
    public int data;

    public Node(){

    }

    public Node(int d){
        this.data = d;
    }

    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
