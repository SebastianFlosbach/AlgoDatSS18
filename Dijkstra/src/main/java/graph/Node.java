package main.java.graph;

import java.util.ArrayList;

public class Node {

	private static int m_IdCounter = 0;
	
	public int Id;
	public ArrayList<Connection> Connections;
	
	
	public Node() {
		Id = m_IdCounter++;
		Connections = new ArrayList<Connection>();
	}


	@Override
	public String toString() {
		return "Node [Id=" + Id + ", Connections=" + Connections.size() + "]";
	}
	
	
	
	
	
}
