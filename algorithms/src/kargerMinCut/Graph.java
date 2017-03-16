package kargerMinCut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.naming.spi.DirStateFactory.Result;

public class Graph {

	HashMap<Node, ArrayList<Node>> adjMap = new HashMap<Node, ArrayList<Node>>();

	public Graph(HashMap<Node, ArrayList<Node>> adjMap) {
		this.adjMap = adjMap;
	}

	// Prints entire graph
	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();
		for (Entry<Node, ArrayList<Node>> entry : adjMap.entrySet()) {
			String pair = new String(entry.getKey().toString() + "=>" + entry.getValue().toString() + "\n");
			result.append(pair);
		}
		return result.toString();
	}
}
