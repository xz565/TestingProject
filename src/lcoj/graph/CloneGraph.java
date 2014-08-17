package lcoj.graph;

import java.util.HashMap;
import java.util.Map;

import lcoj.common.UndirectedGraphNode;

// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
// OJ's undirected graph serialization:
// Nodes are labeled uniquely.
//
// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
// The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:
public class CloneGraph {

  // BFS or DFS
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

    if (node == null) {
      return node;
    }

    Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    return helper(node, map);
  }


  private UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {

    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    if (!map.keySet().contains(node.label)) {
      map.put(node.label, newNode);
    }

    for (UndirectedGraphNode neighbor : node.neighbors) {
      if (!map.keySet().contains(neighbor.label)) {
        helper(neighbor, map);
      }
      newNode.neighbors.add(map.get(neighbor.label));
    }

    return newNode;
  }
}
