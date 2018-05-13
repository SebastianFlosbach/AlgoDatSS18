package entities.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	// Values for dijkstra
	private float m_Distance = Float.MAX_VALUE;
	
	public boolean Visited = false;
	
	private int m_Id;
	
	private List<Edge> m_Edges;
	
	public int GetId() {
		return m_Id;
	}
	
	public float GetDistance() {
		return m_Distance;
	}
	
	public void SetDistance(float distance) {
		m_Distance = distance;
	}
	
	public List<Edge> GetEdges(){
		return m_Edges;
	}
	
	
	public Vertex(int id) {
		m_Id = id;
		m_Edges = new ArrayList<Edge>();
	}


	public void AddEdge(Edge edge) {
		if(m_Edges.contains(edge) == false) {
			m_Edges.add(edge);
		}
	}
	
	public Vertex[] GetNeighbours() {
		
		if(m_Edges.size() == 0)
			return null;
		
		Vertex[] neighbours = new Vertex[m_Edges.size()];
		
		for (int i = 0; i < m_Edges.size(); i++) {
			neighbours[i] = m_Edges.get(i).GetNeighbour(this);
		}
		
		return neighbours;
	}
	
	@Override
	public String toString() {
		return "Vertex [Id=" + m_Id + ", Edges=" + m_Edges.size() + "]";
	}

}
