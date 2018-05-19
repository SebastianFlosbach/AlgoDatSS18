package presentation;

import business.algorithm.Dijkstra;
import entities.graph.Graph;
import entities.graph.Path;
import entities.graph.Vertex;
import entities.priorityqueue.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(8);
		
		pq.Insert(new Vertex(0), 2);
		pq.Insert(new Vertex(1), 4);
		pq.Insert(new Vertex(2), 8);
		pq.Insert(new Vertex(3), 3);
		pq.Insert(new Vertex(4), 1);
	}

}
