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
        Map<Node, Node> copy = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            copy.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            copy.get(curr).next = copy.get(curr.next);
            copy.get(curr).random = copy.get(curr.random);
            curr = curr.next;
        }
        return copy.get(head);
    }
}