package business.algorithm;

import entities.graph.*;
import entities.priorityqueue.VertexPriorityQueue;

/**
 * This class implements Dijkstras and Prims algorithm with a priority queue.
 * @author Sebastian
 *
 */
public class ListPriorityFirst {
	
	private static final int INFINITE = Integer.MAX_VALUE - 1;
	
	private int[] m_Priority;
	private Graph m_Graph;
	
	public ListPriorityFirst(Graph graph) {
		m_Graph = graph;
	}
	
	/**
	 * Execute Dijkstra's algorithm on a graph with specific start Vertex
	 */
	public void Dijkstra() {
		
		m_Priority = new int[m_Graph.GetVertices().length + 1];
		
		for(Vertex v : m_Graph.GetVertices()) {
			m_Priority[v.GetId()] = -INFINITE;
		}
		
		for(Vertex v : m_Graph.GetVertices()) {
			if(m_Priority[v.GetId()] == -INFINITE) {
				visitDijkstra(v);
			}
		}
	}
	
	private void visitDijkstra(Vertex vertex) {
		
		VertexPriorityQueue priorityQueue;
		
		if(vertex.GetNeighbours() != null) {
			priorityQueue = new VertexPriorityQueue(vertex.GetNeighbours().length + 1);
		}
		else {
			priorityQueue = new VertexPriorityQueue(1);
		}
		
		if(priorityQueue.Update(vertex, INFINITE)) {
			vertex.SetParent(null);
		}
		
		while(priorityQueue.IsEmpty() == false) {
			vertex = priorityQueue.Pull();
			m_Priority[vertex.GetId()] = - m_Priority[vertex.GetId()];
			
			if(m_Priority[vertex.GetId()] == INFINITE) {
				
				for(Edge edge : vertex.GetEdges()) {		
					
					Vertex neighbour = edge.GetNeighbour(vertex);
					
					if(m_Priority[neighbour.GetId()] < 0) {
						if(priorityQueue.Update(neighbour, m_Priority[vertex.GetId()] + edge.GetWeight())) {
							m_Priority[neighbour.GetId()] = -(m_Priority[vertex.GetId()] + edge.GetWeight());
							neighbour.SetParent(vertex);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Execute Prim's algorithm on a graph with specific start Vertex
	 */
	public void Prim() {
		
	}
	
}
