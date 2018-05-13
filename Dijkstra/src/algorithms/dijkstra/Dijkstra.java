package algorithms.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import main.java.graph.Edge;
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
		
		// Path from end to start
		Path path = new Path();
		
		// Currently visited vertex
		Vertex currentVertex = null;
		
		// Initialize array that contains the id of the previous vertex in the shortest path to that vertex.
		// For example, if the shortest path to vertex 2 is from vertex 6 then prev[2] = 6.
		// If the vertex doesn't have a previous vertex it is set so Integer.MAX_VALUE.
		int[] previousVertex = new int[m_Graph.GetVertices().length];
		Arrays.fill(previousVertex, Integer.MAX_VALUE);
				
		// Add all vertices except start to unvisited
		for (Vertex vertex : m_Graph.GetVertices()) {				
			if (vertex.GetId() == startId) {
				currentVertex = vertex;
			}
			
			m_Unvisited.add(vertex);
			vertex.Visited = false;
		}
		
		currentVertex.SetDistance(0);	
		
		// While unvisited vertices exist calculate distances
		while (m_Unvisited.size() != 0) {
			
			// Get Vertex with minimum distance to start
			currentVertex = m_Unvisited.stream().min(Comparator.comparing(Vertex::GetDistance)).orElseThrow(NoSuchElementException::new);
			
			// Remove minimum distance vertex from unvisited
			m_Unvisited.remove(currentVertex);
			currentVertex.Visited = true;
			
			// Exit loop if path to end vertex has been found
			if(currentVertex.GetId() == endId)
				break;
			
			// Calculate distance to each unvisited neighbour
			for(Edge edge : currentVertex.GetEdges()) {
						
				Vertex neighbour = edge.GetNeighbour(currentVertex);					
				
				if(neighbour.Visited)
					continue;
				
				// Distance to current neighbour
				float distance = currentVertex.GetDistance() + edge.GetWeight();
				
				// If distance is smaller than neighbours shortest distance set that neighbours distance
				if(distance < neighbour.GetDistance()) {
					neighbour.SetDistance(distance);
					previousVertex[neighbour.GetId()] = currentVertex.GetId();
				}
			}
			
		}
		
		int currentVertexId = endId;
		
		// Get path from end to start by reverse iteration
		while(previousVertex[currentVertexId] != Integer.MAX_VALUE) {
			path.AddWaypoint(currentVertexId);
			currentVertexId = previousVertex[currentVertexId];
		}
		path.AddWaypoint(startId);
		
		return path;
	}
	
}
