package entities.graph;

import java.util.Arrays;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * This class represents a weighted graph
 * @author Sebastian
 *
 */
public class Graph {
	
	//private int m_nextVertexId = 1;
	
	private Vertex[] m_Vertices;
	
	/**
	 * Get an array of all vertices from graph
	 * @return Array of all vertices
	 */
	public Vertex[] GetVertices(){
		return m_Vertices;
	}
	
	/**
	 * Returns a new Graph instance
	 * @param vertices Number of vertices in the graph
	 */
	public Graph(int vertices) {
		m_Vertices = new Vertex[vertices];
		
		for(int i = 1; i <= vertices; i++) {
			m_Vertices[i - 1] = new Vertex(i);
		}
	}	
	
	/**
	 * Add a new Edge between two vertices
	 * @param v1 First vertex
	 * @param v2 Second vertex
	 * @param weight Weight of the edge
	 */
	public void AddEdge(Vertex v1, Vertex v2, int weight) {
		
		if(v1 == null || v2 == null)
			return;
		
		Edge newEdge = new Edge(v1, v2, weight);
		v1.AddEdge(newEdge);
		v2.AddEdge(newEdge);
	}
	
	/**
	 * Add a new Edge between two vertices
	 * @param v1 Id of first vertex
	 * @param v2 Id of second vertex
	 * @param weight Weight of the edge
	 */
	public void AddEdge(int v1, int v2, int weight) {		
		AddEdge(m_Vertices[v1 - 1], m_Vertices[v2 - 1], weight);
	}
	
	/**
	 * Remove an Edge between to vertices
	 * @param v1 First vertex
	 * @param v2 Second vertex
	 * @return True if removal was successful otherwise false
	 */
	public boolean RemoveEdge(Vertex v1, Vertex v2) {
		throw new NotImplementedException();
	}
	
	/**
	 * Get the adjacency matrix from this graph
	 * @return An adjacency matrix
	 */
	public int[][] GetAdjacencyMatrix(){
		
		int[][] matrix = new int[m_Vertices.length][m_Vertices.length];
		
		for(int[] var : matrix) {
			Arrays.fill(var, -(Integer.MAX_VALUE - 1));
		}
		
		for(Vertex vertex : m_Vertices) {
			for(Vertex neighbour : vertex.GetNeighbours()) {
				matrix[vertex.GetId() - 1][neighbour.GetId() - 1] = vertex.GetDistanceToVertex(neighbour);
			}
		}
		
		return matrix;
	}

	/**
	 * Get a string of the graph reduced to the parent connections
	 * @return String of the reduced graph
	 */
	public String GetReducedGraphToString() {
		String graphString = "";

		for(Vertex v : m_Vertices) {

			graphString += v.toString() + " with distance " + v.GetDistance() + "\n";
			
			for(Edge e : v.GetEdges()) {
				if(e.GetNeighbour(v).GetParent() == v) {
					graphString += "\tTo " + e.GetNeighbour(v) + " with weight " + e.GetWeight() + "\n";
				}
			}
		}

		return graphString;
	}

	@Override
	public String toString() {
		String graphString = "";
		
		for(Vertex v : m_Vertices) {
			graphString += v.toString() + "\n";
			
			for(Edge e : v.GetEdges()) {
				graphString += "\tTo " + e.GetNeighbour(v) + " with weight " + e.GetWeight() + "\n";
			}
		}
		
		return graphString;
	}
	
}
