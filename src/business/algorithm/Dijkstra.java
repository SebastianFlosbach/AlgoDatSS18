package business.algorithm;

import java.util.Arrays;

import entities.graph.*;
import entities.priorityqueue.VertexPriorityQueue;

public class Dijkstra {
	

	public static Path FindShortestPath(Graph graph, int startId, int endId) {
		
		VertexPriorityQueue m_Unvisited = new VertexPriorityQueue(graph.GetVertices().length);
		
		// Path from end to start
		Path shortestPathEndToStart = new Path();
		
		// Currently visited vertex
		Vertex currentVertex = null;
		
		// Initialize array that contains the id of the previous vertex in the shortest path to that vertex.
		// For example, if the shortest path to vertex 2 is from vertex 6 then prev[2] = 6.
		// If the vertex doesn't have a previous vertex it is -1.
		int[] previousVertex = new int[graph.GetVertices().length + 1];
		Arrays.fill(previousVertex, -1);
		
		// Add vertices to unvisited set distance of start vertex to 0
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
			
			// Exit loop if path to end vertex has been found
			if(currentVertex.GetId() == endId)
				break;
			
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
					previousVertex[neighbour.GetId()] = currentVertex.GetId();
				}
			}
			
		}
		
		int currentVertexId = endId;
		
		// Get path from end to start by reverse iteration
		while(previousVertex[currentVertexId] != -1) {
			shortestPathEndToStart.AddWaypoint(currentVertexId);
			currentVertexId = previousVertex[currentVertexId];
		}
		shortestPathEndToStart.AddWaypoint(startId);
		
		return shortestPathEndToStart;
	}
	
}
