package entities.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a vertex inside a graph
 * @author Sebastian
 *
 */
public class Vertex {
	
	private int m_Id;
	
	private int m_Distance = Integer.MAX_VALUE;
	
	private List<Edge> m_Edges;
	
	/**
	 * Marker if this vertex was visited by the Dijkstra algorithm
	 */
	public boolean Visited = false;	
	
	
	/**
	 * Get distance to a specific vertex depending on the used algorithm.
	 * @return Distance as float value, initialized with Float.MAX_VALUE
	 */
	public int GetDistance() {
		return m_Distance;
	}
	
	private Vertex m_Parent;
	
	public Vertex GetParent() {
		return m_Parent;
	}
	
	public void SetParent(Vertex v) {
		m_Parent = v;
	}
	
	/**
	 * Set distance to a specific vertex depending on the used algorithm.
	 * @param _distance The new distance
	 */
	public void SetDistance(int _distance) {
		m_Distance = _distance;
	}
	
	/**
	 * Get id of this vertex
	 * @return Id of this vertex
	 */
	public int GetId() {
		return m_Id;
	}	
	
	/**
	 * Get all edges of this vertex
	 * @return List of Edges
	 */
	public List<Edge> GetEdges(){
		return m_Edges;
	}
	
	
	/**
	 * Create a new vertex
	 * @param id Id of the new vertex
	 */
	public Vertex(int id) {
		m_Id = id;
		m_Edges = new ArrayList<Edge>();
	}


	/**
	 * Add Edge to this vertex
	 * @param edge The edge to add
	 */
	public void AddEdge(Edge edge) {
		if(m_Edges.contains(edge) == false) {
			m_Edges.add(edge);
		}
	}
	
	/**
	 * Get all neighbors of this vertex
	 * @return Array of all neighboring vertices
	 */
	public Vertex[] GetNeighbours() {
		
		if(m_Edges.size() == 0)
			return null;
		
		Vertex[] neighbours = new Vertex[m_Edges.size()];
		
		for (int i = 0; i < m_Edges.size(); i++) {
			neighbours[i] = m_Edges.get(i).GetNeighbour(this);
		}
		
		return neighbours;
	}
	
	/**
	 * Get distance to another vertex
	 * @param _vertex Vertex to get distance to
	 * @return Distance to vertex, 0 if vertex is the same, Float.MAX_VALUE if vertices aren't neighbors
	 */
	public float GetDistanceToVertex(Vertex _vertex) {
		
		if(this.equals(_vertex))
			return 0f;
		
		int distance = Integer.MAX_VALUE;
		
		for(Edge edge : this.GetEdges()) {
			if(edge.GetNeighbour(this).equals(_vertex)) {
				distance = edge.GetWeight();
				break;
			}
		}
		
		return distance;	
	}
	
	@Override
	public String toString() {
		return "Vertex [Id=" + m_Id + "]";
	}

}
