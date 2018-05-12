package main.java.graph;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
	
	private static int m_IdCounter = 0;
	
	// Values for dijkstra
	public float Distance = Float.MAX_VALUE;
	
	public int Id;
	
	private ArrayList<Edge> Edges;
	
	
	public Vertex() {
		Id = m_IdCounter++;
		Edges = new ArrayList<Edge>();
	}


	public void AddEdge(Edge edge) {
		if(Edges.contains(edge) == false) {
			Edges.add(edge);
		}
	}
	
	@Override
	public String toString() {
		return "Vertex [Id=" + Id + ", Edges=" + Edges.size() + "]";
	}

	@Override
	public int compareTo(Vertex arg) {		
		if(this.Id > arg.Id)
			return 1;
		else if(this.Id < arg.Id)
			return -1;
		else
			return 0;
	}
}
