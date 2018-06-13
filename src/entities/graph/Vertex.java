package entities.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private int m_Id;
	
	private float m_DistanceToSource;
	
	private List<Edge> m_Edges;
	
	/**
	 * Marker if this vertex was visited by the Dijkstra algorithm
	 */
	public boolean Visited = false;	
	
	
	/**
	 * Get distance to source vertex
	 * @return
	 */
	public float GetDistanceToSource() {
		return m_DistanceToSource;
	}
	
	/**
	 * Set distance to source vertex
	 * @param _distance
	 */
	public void SetDistanceToSource(float _distance) {
		m_DistanceToSource = _distance;
	}
	
	/**
	 * Get id of this vertex
	 * @return
	 */
	public int GetId() {
		return m_Id;
	}	
	
	/**
	 * Get all edges of this vertex
	 * @return
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
	 * @param edge
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
	 * @param _vertex
	 * @return Distance to vertex, 0 if vertex is the same, Float.MAX_VALUE if vertices aren't neighbors
	 */
	public float GetDistanceToVertex(Vertex _vertex) {
		
		if(this.equals(_vertex))
			return 0f;
		
		float distance = Float.MAX_VALUE;
		
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
