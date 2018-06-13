package business.algorithm;

import entities.graph.*;
import entities.priorityqueue.VertexPriorityQueue;

/**
 * This class implements Dijkstras and Prims algorithm with a priority queue.
 * @author Sebastian
 *
 */
public class ListPriorityFirst {
	
	/**
	 * Execute Dijkstras algorithm on a graph with specific start Vertex
	 * @param graph Graph to execute on
	 * @param startId Id of the start Vertex
	 */
	public static void Dijkstra(Graph graph, int startId) {
		
		VertexPriorityQueue m_Unvisited = new VertexPriorityQueue(graph.GetVertices().length);
		
		// Currently visited vertex
		Vertex currentVertex = null;
		
		// Add vertices to unvisited, set distance of start vertex to 0
		for (Vertex vertex : graph.GetVertices()) {
			if (vertex.GetId() == startId) {
				vertex.SetDistanceToSource(0);			
			}
			else
			{
				vertex.SetDistanceToSource(Float.MAX_VALUE);				
			}
			
			m_Unvisited.Insert(vertex);
		}
		
		// While unvisited vertices exist calculate distances
		while (m_Unvisited.IsEmpty() == false) {
			
			// Get Vertex with minimum distance to start
			currentVertex = m_Unvisited.Pull();
			
			// Calculate distance to each unvisited neighbour
			for(Edge edge : currentVertex.GetEdges()) {
						
				Vertex neighbour = edge.GetNeighbour(currentVertex);
				
				if(neighbour.Visited)
					continue;
				
				// Distance to current neighbour
				float distance = currentVertex.GetDistanceToSource() + edge.GetWeight();
				
				// If distance is smaller than neighbours shortest distance set that neighbours distance
				if(distance < neighbour.GetDistanceToSource()) {
					m_Unvisited.Update(neighbour, distance);
				}				
			}		
		}
	}
	
	public static void Prim(Graph graph, int startId) {
		
		VertexPriorityQueue m_Unvisited = new VertexPriorityQueue(graph.GetVertices().length);
		
		// Currently visited vertex
		Vertex currentVertex = null;
		
		// Add vertices to unvisited, set distance of start vertex to 0
		for (Vertex vertex : graph.GetVertices()) {
			if (vertex.GetId() == startId) {
				vertex.SetDistanceToSource(0);			
			}
			else
			{
				vertex.SetDistanceToSource(Float.MAX_VALUE);				
			}
			
			m_Unvisited.Insert(vertex);
		}
		
		// While unvisited vertices exist calculate distances
		while (m_Unvisited.IsEmpty() == false) {
			
			// Get Vertex with minimum distance to start
			currentVertex = m_Unvisited.Pull();
			
			// Calculate distance to each unvisited neighbour
			for(Edge edge : currentVertex.GetEdges()) {
						
				Vertex neighbour = edge.GetNeighbour(currentVertex);
				
				if(neighbour.Visited)
					continue;
				
				// Distance to current neighbour
				float distance = edge.GetWeight();
				
				m_Unvisited.Update(neighbour, distance);			
			}		
		}
	}
	
}
