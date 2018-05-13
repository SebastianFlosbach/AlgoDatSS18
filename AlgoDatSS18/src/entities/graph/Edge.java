package entities.graph;

public class Edge {
	
	private float m_Weight;
	
	private Vertex m_Vertex1;
	private Vertex m_Vertex2;
	
	public float GetWeight() {
		return m_Weight;
	}
	
	public Edge(Vertex v1, Vertex v2, float weight) {
		m_Vertex1 = v1;
		m_Vertex2 = v2;
		
		m_Weight = weight;
	}
	
	public Vertex GetNeighbour(Vertex current) {
		
		if(current == m_Vertex1)
			return m_Vertex2;
		if(current == m_Vertex2)
			return m_Vertex1;
		
		return null;
	}
	
}
