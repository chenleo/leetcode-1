/*
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 *
 * http://oj.leetcode.com/problems/clone-graph/
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = null;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        map = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        UndirectedGraphNode copy = null;

        if (node != null) {
            if (map.containsKey(node.label)) copy = map.get(node.label); 
            else {
                copy = new UndirectedGraphNode(node.label);
                map.put(node.label, copy); // **important** must be added first
                for (UndirectedGraphNode n: node.neighbors)
                    copy.neighbors.add(clone(n));
            }
        }
        
        return copy;
    }
}

public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = null;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (node == null) return null;

        map = new HashMap<Integer, UndirectedGraphNode>();

        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            UndirectedGraphNode copy = safeCopy(n);
            for (UndirectedGraphNode neighbor: n.neighbors) {
                if (!map.containsKey(neighbor.label)) q.add(neighbor);
                copy.neighbors.add(safeCopy(neighbor));
            }
        }
        return map.get(node.label);
    }
    
    private UndirectedGraphNode safeCopy (UndirectedGraphNode node) {
        UndirectedGraphNode copy = null;
        if (map.containsKey(node.label)) copy = map.get(node.label);
        else {
            copy = new UndirectedGraphNode(node.label);
            map.put(node.label, copy);
        }
        return copy;
    }
}
