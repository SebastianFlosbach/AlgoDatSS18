package presentation;

import java.io.IOException;

import business.algorithm.ListAlgorithms;
import business.algorithm.MatrixPriorityFirst;
import entities.graph.Graph;
import entities.graph.Path;
import data.XmlGraphReader;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Djikstra/Prim Test Program");
		System.out.println("--------------------------");
		System.out.println();
		System.out.print("Select graph: ");
		
		String input = System.console().readLine();
		
		clearConsole();
		
	}
	
	static void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
