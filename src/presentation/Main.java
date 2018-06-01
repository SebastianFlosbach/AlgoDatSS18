package presentation;

import business.algorithm.Dijkstra;
import business.algorithm.Prim;
import entities.graph.Graph;
import entities.graph.Path;
import data.XmlGraphReader;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Program start");
		
//		if(args.length > 0 && args[0] != null) {
//			XmlGraphReader reader = new XmlGraphReader(args[0]);
//
//			Graph graph = reader.ReadGraph();
//
//			Path path = Dijkstra.FindShortestPath(graph, 5, 2);
//
//			System.out.println(path);
//		}
//		else {
//			System.out.println("No valid argument");
//		}


		int input[][] = new int[][]{{0,2,0,6,0},{2,0,3,8,5},{0,3,0,0,7},{6,8,0,0,9},{0,5,7,9,0}};

		Prim test = new Prim();

		test.MatrixPriorityFirst(input);
	}

}
