package Q146_LRUCache;

import java.util.HashMap;

class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
        Node(int key, int val, Node prev, Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    int st;
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.st = 0;
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node keyNode = map.getOrDefault(key, null);
        // System.out.println(map);
        if(keyNode == null){
            return -1;
        }

        moveHead(keyNode);
        //System.out.println("get: " + key);
        //printLRU();
        return keyNode.val;
    }

    public void put(int key, int value) {
        //System.out.println("put: " + key + " " + value);
        // contains key
        Node keyNode = map.getOrDefault(key, null);
        if(keyNode != null){
            moveHead(keyNode);
            keyNode.val = value;
            //printLRU();
            return;
        }

        // the key is not contained
        // the size not full
        if(st != capacity){
            st++;
            insertHead(key, value);
            //printLRU();
            return;
        }

        // the size is full
        removeFinal();
        insertHead(key, value);
        //printLRU();
    }

    private void moveHead(Node targetNode){
        Node curPrev = targetNode.prev;
        if(curPrev == head) return;

        Node curNext = targetNode.next;
        Node orgFirst = head.next;

        // back connect
        curPrev.next = curNext;
        curNext.prev = curPrev;
        // get itself connect
        targetNode.next = orgFirst;
        targetNode.prev = head;
        // cut first
        head.next = targetNode;
        orgFirst.prev = targetNode;
    }

    private void insertHead(int key, int value){
        Node node0 = new Node(value);
        node0.key = key;
        Node orgFirst = head.next;

        node0.next = orgFirst;
        node0.prev = head;

        head.next = node0;
        orgFirst.prev = node0;

        map.put(key, node0);
    }

    private void removeFinal(){
        Node lastNode = tail.prev;
        if(lastNode == head) return;
        Node last2Node = lastNode.prev;
        last2Node.next = tail;
        tail.prev = last2Node;

        map.remove(lastNode.key);  // remove from the map
    }

    private void printLRU(){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
