package stronglyConnectedComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph {

	public HashMap<Node, ArrayList<Node>> edgeMap = new HashMap<Node, ArrayList<Node>>();
	public HashMap<Node, Boolean> isExploredMap = new HashMap<Node, Boolean>();
	public Set<Node> nodeList = new HashSet<Node>();

	public void addEdge(Integer fromVertex, Integer toVertex) {

		Node fromNode = new Node(fromVertex);
		Node toNode = new Node(toVertex);
		addEdge(fromNode, toNode);
	}

	public void addEdge(Node fromNode, Node toNode) {

		if (this.edgeMap.containsKey(fromNode)) {
			ArrayList<Node> valueNodes = this.edgeMap.get(fromNode);
			valueNodes.add(toNode);
			this.edgeMap.put(fromNode, valueNodes);
			isExploredMap.put(toNode, false);
			nodeList.add(toNode);
		} else {
			ArrayList<Node> valueNode = new ArrayList<Node>();
			valueNode.add(toNode);
			this.edgeMap.put(fromNode, valueNode);
			// add to isExploredMap
			isExploredMap.put(fromNode, false);
			isExploredMap.put(toNode, false);
			// Add nodes to list nodeList
			nodeList.add(fromNode);
			nodeList.add(toNode);
		}
	}

	public void resetToUnexplored() {

		Iterator<Map.Entry<Node, Boolean>> iter = isExploredMap.entrySet().iterator();
		while (iter.hasNext()) {
			iter.next().setValue(false);
		}
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();
		for (Entry<Node, ArrayList<Node>> entry : edgeMap.entrySet()) {
			String edge = new String(entry.getKey().toString() + "=>" + entry.getValue().toString() + "\n");
			Node leader = entry.getKey().leader;
			result.append(edge);
			if (leader != null) {
				String printLeader = " Leader is (" + leader.toString() + ") \n";
				result.append(printLeader);
			}
		}
		return result.toString();
	}
}
