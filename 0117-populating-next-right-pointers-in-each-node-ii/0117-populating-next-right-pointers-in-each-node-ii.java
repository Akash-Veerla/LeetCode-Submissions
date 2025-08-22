/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node levelStart = root;
        while (levelStart != null) {
            Node temp = new Node(0);
            Node currChild = temp, current = levelStart;
            while (current != null) {
                if (current.left != null) {
                    currChild.next = current.left;
                    currChild = currChild.next;
                }
                if (current.right != null) {
                    currChild.next = current.right;
                    currChild = currChild.next;
                }
                current = current.next;
            }
            levelStart = temp.next;
        }
        return root;
    }
}