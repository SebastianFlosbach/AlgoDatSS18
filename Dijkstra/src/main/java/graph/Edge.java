package main.java.graph;

public class Edge {
	
	public float Weight;
	
	private Vertex m_Vertex1;
	private Vertex m_Vertex2;
	
	public Edge(Vertex v1, Vertex v2, float weight) {
		m_Vertex1 = v1;
		m_Vertex2 = v2;
		
		Weight = weight;
	}
	
	public Vertex GetNextVertex(Vertex current) {
		
		if(current == m_Vertex1)
			return m_Vertex2;
		if(current == m_Vertex2)
			return m_Vertex1;
		
		return null;
	}
	
}
