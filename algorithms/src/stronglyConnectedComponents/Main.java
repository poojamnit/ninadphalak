package stronglyConnectedComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//String inputPath = args[0];
		String inputPath = "/home/ninad/workspace/java_personal/resources/ssc_testcase1.txt";
		Path path = Paths.get(inputPath);
		Graph graph = new Graph();
		Graph reverseGraph = new Graph();
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			
			String line = null;
			while((line = reader.readLine()) != null){
				if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
					continue;
				}
				String[] edge = line.split("\\s");
				Integer fromVertex = Integer.parseInt(edge[0]);
				Integer toVertex = Integer.parseInt(edge[1]);
				graph.addEdge(fromVertex,toVertex);
				reverseGraph.addEdge(toVertex, fromVertex);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//System.out.println("Graph is: \n" + graph.toString());
		//DFS.depthFirstSearch(graph,new Node(1));
		DFS.dfsTwoPass(graph,reverseGraph);
		System.out.println("The largest five SSC are: " + Arrays.toString(DFS.sscLargestFive));
		//System.out.println("processed graph is: " + graph.toString());
	}
}
