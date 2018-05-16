package business.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import entities.graph.Edge;
import entities.graph.Graph;
import entities.graph.Path;
import entities.graph.Vertex;

public class Dijkstra {
	

	public static Path FindShortestPath(Graph graph, int startId, int endId) {
		
		PriorityQueue<Vertex> m_Unvisited = new PriorityQueue<Vertex>(Comparator.comparing(Vertex::GetDistance));
		
		// Path from end to start
		Path shortestPathEndToStart = new Path();
		
		// Currently visited vertex
		Vertex currentVertex = null;
		
		// Initialize array that contains the id of the previous vertex in the shortest path to that vertex.
		// For example, if the shortest path to vertex 2 is from vertex 6 then prev[2] = 6.
		// If the vertex doesn't have a previous vertex it is set so Integer.MAX_VALUE.
		int[] previousVertex = new int[graph.GetVertices().length];
		Arrays.fill(previousVertex, Integer.MAX_VALUE);
				
		// Add vertices to unvisited set currentVertex to the start vertex
		for (Vertex vertex : graph.GetVertices()) {				
			if (vertex.GetId() == startId) {
				currentVertex = vertex;
			}
			else {
				m_Unvisited.add(vertex);
				vertex.Visited = false;
			}			
		}
		
		// Distance of the start vertex is 0
		currentVertex.SetDistance(0);
		m_Unvisited.add(currentVertex);
		
		// While unvisited vertices exist calculate distances
		while (m_Unvisited.size() != 0) {
			
			// Get Vertex with minimum distance to start
			currentVertex = m_Unvisited.poll();
			
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
					
					m_Unvisited.remove(neighbour);
					m_Unvisited.add(neighbour);
				}
			}
			
		}
		
		int currentVertexId = endId;
		
		// Get path from end to start by reverse iteration
		while(previousVertex[currentVertexId] != Integer.MAX_VALUE) {
			shortestPathEndToStart.AddWaypoint(currentVertexId);
			currentVertexId = previousVertex[currentVertexId];
		}
		shortestPathEndToStart.AddWaypoint(startId);
		
		return shortestPathEndToStart;
	}
	
}
