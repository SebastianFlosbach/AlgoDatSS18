package main.java.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> Vertices;
	
	
	public Graph() {
		Vertices = new ArrayList<Vertex>();
	}
	
	
	public void AddVertex() {
		Vertices.add(new Vertex());
		Vertices.sort(null);
	}
	
	public void AddEdge(Vertex v1, Vertex v2, float weight) {
		
		if(v1 == null || v2 == null)
			return;
		
		Edge newEdge = new Edge(v1, v2, weight);
		v1.AddEdge(newEdge);
		v2.AddEdge(newEdge);
	}
	
	public void AddEdge(int v1, int v2, float weight) {
		Vertex vert1 = Vertices.stream().filter(v -> v.Id == v1).findFirst().get();
		Vertex vert2 = Vertices.stream().filter(v -> v.Id == v2).findFirst().get();
		
		AddEdge(vert1, vert2, weight);
	}
	
}
