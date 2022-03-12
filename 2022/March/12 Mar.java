/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(0), tail = newHead, h = head;
        Map<Node, Node> map = new HashMap<>();
        while(head != null) {
            tail.next = new Node(head.val);
            tail = tail.next;
            map.put(head, tail);
            head = head.next;
        }
        tail = newHead.next;
        while(h != null) {
            if(h.random != null) tail.random = map.get(h.random);
            tail = tail.next;
            h = h.next;
        }
        return newHead.next;
    }
}
