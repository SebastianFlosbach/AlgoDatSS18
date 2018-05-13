package presentation;

import business.algorithm.Dijkstra;
import entities.graph.Graph;
import entities.graph.Path;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph(5);
		
		graph.AddEdge(0, 1, 1);
		graph.AddEdge(0, 2, 1);
		graph.AddEdge(1, 2, 4);
		graph.AddEdge(1, 3, 4);
		graph.AddEdge(2, 3, 1);
		graph.AddEdge(2, 4, 4);
		graph.AddEdge(3, 4, 1);
		
		Dijkstra dijkstra = new Dijkstra(graph);
		
		Path shortestPath = dijkstra.FindShortestPath(4, 1);
		
		for(int i = shortestPath.GetPathIds().size() - 1; i >= 0; i--) {
			System.out.println("Vertex: " + shortestPath.GetPathIds().get(i));
		}
	}

}
