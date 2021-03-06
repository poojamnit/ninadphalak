package kargerMinCut;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		// Below you can use a runtime argument instead of a hardcoded path
		/*
		 * String path = args[0]; Path path = Paths.get(args[0]);
		 */
		String inputPath = "/home/ninad/workspace/java_personal/karger1.txt";
		Path path = Paths.get(inputPath);
		// HashMap contains Adjacency list mapping of each vertex to it's
		// adjacent vertices
		// Key Point: Parallel edges between vertices are denoted by duplicate
		// node in the ArrayList
		HashMap<Node, ArrayList<Node>> adjMap = new HashMap<Node, ArrayList<Node>>();
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
					continue;
				}
				String[] nodesInLine = line.split("\\s");
				ArrayList<Node> adjacentNodes = new ArrayList<Node>();
				for (int i = 1; i < nodesInLine.length; i++) {
					Node n = new Node(Integer.parseInt(nodesInLine[i]));
					adjacentNodes.add(n);
				}
				Node node = new Node(Integer.parseInt(nodesInLine[0]));
				adjMap.put(node, adjacentNodes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graph graph = new Graph(adjMap);
		System.out.println("Input Graph is: " + "\n" + graph.toString());
		int minCut = KargerMinCut.kargerMinCut(graph);
		System.out.println("Karger's minCut is: " + minCut);
	}
}
