package main.java.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> m_Vertices;
	
	public List<Vertex> GetVertices(){
		return m_Vertices;
	}
	
	
	public Graph() {
		m_Vertices = new ArrayList<Vertex>();
	}
	
	public void AddVertices(int number) {
		for(int i = 0; i < number; i++)
			m_Vertices.add(new Vertex());
	}
	
	public void AddEdge(Vertex v1, Vertex v2, float weight) {
		
		if(v1 == null || v2 == null)
			return;
		
		Edge newEdge = new Edge(v1, v2, weight);
		v1.AddEdge(newEdge);
		v2.AddEdge(newEdge);
	}
	
	public void AddEdge(int v1, int v2, float weight) {
		Vertex vert1 = m_Vertices.stream().filter(v -> v.Id == v1).findFirst().get();
		Vertex vert2 = m_Vertices.stream().filter(v -> v.Id == v2).findFirst().get();
		
		AddEdge(vert1, vert2, weight);
	}
	
}
