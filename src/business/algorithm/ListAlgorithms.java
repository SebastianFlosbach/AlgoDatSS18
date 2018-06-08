package business.algorithm;

import entities.graph.*;
import entities.priorityqueue.VertexPriorityQueue;

public class ListAlgorithms {
	

	public static Path Dijkstra(Graph graph, int startId, int endId) {
		
		VertexPriorityQueue m_Unvisited = new VertexPriorityQueue(graph.GetVertices().length);
		
		// Path from end to start
		Path shortestPathEndToStart = new Path();
		
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
		
		shortestPathEndToStart.AddWaypoint(m_Unvisited.Peek());
		
		// While unvisited vertices exist calculate distances
		while (m_Unvisited.IsEmpty() == false) {
			
			// Get Vertex with minimum distance to start
			currentVertex = m_Unvisited.Pull();
			
			// Exit loop if path to end vertex has been found
			if(currentVertex.GetId() == endId)
				break;
			
			Vertex nextVertex = null;
			
			// Calculate distance to each unvisited neighbour
			for(Edge edge : currentVertex.GetEdges()) {
						
				Vertex neighbour = edge.GetNeighbour(currentVertex);
				
				if(neighbour.Visited)
					continue;
				
				// Distance to current neighbour
				float distance = currentVertex.GetDistanceToSource() + edge.GetWeight();
				
				// If distance is smaller than neighbours shortest distance set that neighbours distance
				if(distance < neighbour.GetDistanceToSource()) {
					neighbour.SetDistanceToSource(distance);
					m_Unvisited.Update(neighbour);
					nextVertex = neighbour;
				}				
			}		
			
			if(nextVertex != null)
				shortestPathEndToStart.AddWaypoint(nextVertex);
		}
		
		return shortestPathEndToStart;
		
	}
	
}
