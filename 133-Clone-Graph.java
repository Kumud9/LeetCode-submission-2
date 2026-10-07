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
     Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }
    public Node dfs(Node original) {
        if (original == null)
            return null;
        if (map.containsKey(original))
            return map.get(original);
        Node copy = new Node(original.val);
        map.put(original, copy);
        for (Node n : original.neighbors)
            copy.neighbors.add(dfs(n));
        return copy;
    }
}