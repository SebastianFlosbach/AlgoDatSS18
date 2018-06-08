package entities.graph;

import java.util.Arrays;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Graph {
	
	//private int m_nextVertexId = 1;
	
	private Vertex[] m_Vertices;
	
	public Vertex[] GetVertices(){
		return m_Vertices;
	}
	
	
	public Graph(int vertices) {
		m_Vertices = new Vertex[vertices];
		
		for(int i = 1; i <= vertices; i++) {
			m_Vertices[i - 1] = new Vertex(i);
		}
	}	
	
	public void AddEdge(Vertex v1, Vertex v2, float weight) {
		
		if(v1 == null || v2 == null)
			return;
		
		Edge newEdge = new Edge(v1, v2, weight);
		v1.AddEdge(newEdge);
		v2.AddEdge(newEdge);
	}
	
	public void AddEdge(int v1, int v2, float weight) {		
		AddEdge(m_Vertices[v1 - 1], m_Vertices[v2 - 1], weight);
	}
	
	public float[][] GetAdjacentMatrix(){
		
		float[][] matrix = new float[m_Vertices.length][m_Vertices.length];
		
		for(float[] var : matrix) {
			Arrays.fill(var, Float.MAX_VALUE);
		}
		
		for(Vertex vertex : m_Vertices) {
			for(Vertex neighbour : vertex.GetNeighbours()) {
				matrix[vertex.GetId() - 1][neighbour.GetId() - 1] = vertex.GetDistanceToVertex(neighbour);
			}
		}
		
		return matrix;
	}
	
	public static Graph GetGraphFromAdjacentMatrix() {
		throw new NotImplementedException();
	}
	
}
