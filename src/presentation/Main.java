package presentation;

import business.algorithm.ListPriorityFirst;
import data.XmlGraphReader;
import entities.graph.Graph;

public class Main {

	public static void main(String[] args) {
/*
		if(args != null && args.length > 0) {
			GraphTester tester = new GraphTester(args[0]);
			
			tester.Run();
		}
		else {
			System.out.println("Missing argument: Path to graphs!");
		}
		
*/		
	
		XmlGraphReader reader = new XmlGraphReader("C:\\Users\\Sebastian\\Desktop\\AlgoDatSS18\\graphs\\graph1.xml");
		
		Graph graph = reader.ReadGraph();
		
		ListPriorityFirst lpf = new ListPriorityFirst(graph);
		
		lpf.Dijkstra();
		
	}
	
	

}
