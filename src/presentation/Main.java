package presentation;

import business.algorithm.Dijkstra;
import entities.graph.Graph;
import entities.graph.Path;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph(5);
		
		graph.AddEdge(1, 2, 1);
		graph.AddEdge(1, 3, 1);
		graph.AddEdge(2, 3, 4);
		graph.AddEdge(2, 4, 4);
		graph.AddEdge(3, 4, 1);
		graph.AddEdge(3, 5, 4);
		graph.AddEdge(4, 5, 1);
		
		Path path = Dijkstra.FindShortestPath(graph, 5, 2);
		
		for(int i = path.GetPathIds().size() - 1; i >= 0; i--) {
			System.out.println(path.GetPathIds().get(i));
		}
		
	}

}
