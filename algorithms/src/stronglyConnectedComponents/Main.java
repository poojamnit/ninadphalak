package stronglyConnectedComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		//String inputPath = args[0];
		String inputPath = "";
		Path path = Paths.get(inputPath);
		Graph graph = new Graph();
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String line = null;
			while((line = reader.readLine()) != null){
				String[] edge = line.split("\\s");
				Integer fromVertex = Integer.parseInt(edge[0]);
				Integer toVertex = Integer.parseInt(edge[1]);
				graph.addEdge(fromVertex,toVertex,graph);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
}
