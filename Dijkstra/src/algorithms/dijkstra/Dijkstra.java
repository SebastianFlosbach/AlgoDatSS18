package algorithms.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import main.java.graph.Graph;
import main.java.graph.Path;
import main.java.graph.Vertex;

public class Dijkstra {
	
	private Graph m_Graph;
	private List<Vertex> m_Unvisited;
	
	
	public Dijkstra(Graph graph) {
		m_Graph = graph;
		m_Unvisited = new ArrayList<Vertex>();
		
	}
	
	public Path FindShortestPath(int startId, int endId) {
		
		Vertex startVertex = null;
		Vertex currentVertex = null;
		
		// Add all vertices except start to unvisited
		for (Vertex vertex : m_Graph.GetVertices()) {				
			if (vertex.Id == startId) {
				startVertex = vertex;
			}
			
			m_Unvisited.add(vertex);
		}
		
		startVertex.SetDistance(0);
		
		while (m_Unvisited.size() != 0) {
			
			// Get Vertex with minimum distance to start
			currentVertex = m_Unvisited.stream().min(Comparator.comparing(Vertex::GetDistance)).orElseThrow(NoSuchElementException::new);
			
			m_Unvisited.remove(currentVertex);
			
		}
		
		return null;
	}
	
}
