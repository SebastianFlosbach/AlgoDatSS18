package presentation;

import java.io.IOException;

import business.algorithm.ListAlgorithms;
import business.algorithm.MatrixPriorityFirst;
import entities.graph.Graph;
import entities.graph.Path;
import data.XmlGraphReader;

public class Main {

	public static void main(String[] args) {
		
		if(args != null && args.length > 0) {
			GraphTester tester = new GraphTester(args[0]);
			
			tester.Run();
		}
		else {
			System.out.println("Missing argument: Path to graphs!");
		}
		
		
		
	}
	
	

}
