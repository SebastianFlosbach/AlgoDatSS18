package entities.graph;

/**
 * This class represents an Edge inside a graph
 * @author Sebastian
 *
 */
public class Edge {
	
	private float m_Weight;
	
	private Vertex m_Vertex1;
	private Vertex m_Vertex2;
	
	/**
	 * Get weight of this edge
	 * @return Weight of this edge
	 */
	public float GetWeight() {
		return m_Weight;
	}
	
	/**
	 * Create a new Edge instance
	 * @param v1 First vertex
	 * @param v2 Second vertex
	 * @param weight Weight of the edge
	 */
	public Edge(Vertex v1, Vertex v2, float weight) {
		m_Vertex1 = v1;
		m_Vertex2 = v2;
		
		m_Weight = weight;
	}
	
	/**
	 * Get the connected vertex
	 * @param current The starting vertex
	 * @return The connected vertex, null in any other case
	 */
	public Vertex GetNeighbour(Vertex current) {
		
		if(current == m_Vertex1)
			return m_Vertex2;
		if(current == m_Vertex2)
			return m_Vertex1;
		
		return null;
	}
	
}
