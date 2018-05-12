package main.java.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private static int m_IdCounter = 0;
	
	// Values for dijkstra
	private float m_Distance = Float.MAX_VALUE;
	
	public boolean Visited = false;
	
	public int Id;
	
	private List<Edge> m_Edges;
	
	
	public float GetDistance() {
		return m_Distance;
	}
	
	public void SetDistance(float distance) {
		m_Distance = distance;
	}
	
	public List<Edge> GetEdges(){
		return m_Edges;
	}
	
	
	public Vertex() {
		Id = m_IdCounter++;
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
			neighbours[i] = m_Edges.get(i).GetNextVertex(this);
		}
		
		return neighbours;
	}
	
	@Override
	public String toString() {
		return "Vertex [Id=" + Id + ", Edges=" + m_Edges.size() + "]";
	}

}
