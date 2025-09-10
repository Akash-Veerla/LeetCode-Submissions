/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node DFS(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        for (Node temp : node.neighbors) {
            if (map.containsKey(temp)) {
                newNode.neighbors.add(map.get(temp));
            } else {
                newNode.neighbors.add(DFS(temp, map));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        Node head = DFS(node, map);
        return head;
    }
}