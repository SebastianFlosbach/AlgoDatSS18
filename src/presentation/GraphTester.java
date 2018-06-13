package presentation;

import java.io.File;
import java.io.IOException;

import business.algorithm.ListPriorityFirst;
import business.algorithm.MatrixPriorityFirst;
import entities.graph.Graph;
import data.XmlGraphReader;

/**
 * Interface to test Dijkstra's and Prim's algorithm with different graphs 
 * @author Sebastian
 *
 */
public class GraphTester {

	private String m_PathToGraphs;
	
	private File[] m_ListOfGraphs;
	
	private File[] GetListOfGraphs() {
		
		if(m_ListOfGraphs == null) {
			File folder = new File(m_PathToGraphs);
			m_ListOfGraphs = folder.listFiles();
		}
		
		return m_ListOfGraphs;
	}
	
	private Graph currentGraph;
	private Algorithm algorithm;
	private ExecutionType executionType;
	
	public GraphTester(String _pathToGraphs) {
		m_PathToGraphs = _pathToGraphs;
	}
	
	/**
	 * Run the draw loop
	 */
	public void Run() {
		
		boolean isRunning = true;
		ViewState viewState = ViewState.Initial;
		
		while(isRunning) {
			clearConsole();
			
			printHeader();
			
			switch (viewState) {
			case Initial:
				viewState = printInitial();
				break;
			case AlgoSelection:
				viewState = printAlgoSelection();
				break;
			case Graph:
				viewState = printGraph();
				break;
			default:
				break;
			}
		}		
		
	}
	
	private void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private enum ViewState {
		Initial,
		Graph,
		AlgoSelection,
	}
	
	private enum Algorithm {
		Dijkstra,
		Prim,
	}
	
	private enum ExecutionType {
		Matrix,
		List,
	}
	
	private Graph GetGraphFromFile(File file) {
		XmlGraphReader reader = new XmlGraphReader(file.getAbsolutePath());
		return reader.ReadGraph();
	}
	
	private void printHeader() {
		System.out.println("Djikstra/Prim Test Program");
		System.out.println("--------------------------");
		System.out.println();
	}
	
	private ViewState printInitial() {
		System.out.println("Available graphs:");
		
		for(File graphFile : GetListOfGraphs()) {
			System.out.println("\t" + graphFile.getName());
		}
		
		System.out.println();
		System.out.print("Select graph: ");
		
		String input = System.console().readLine();
		
		for(File graphFile : GetListOfGraphs()) {
			if(graphFile.getName().equals(input)) {
				currentGraph = GetGraphFromFile(graphFile);
				break;
			}
		}
		
		if(currentGraph == null)
		{
			System.out.println("This graph does not exist!");
			System.out.println("Press Enter to continue...");
			System.console().readLine();
			return ViewState.Initial;
		}
		else {
			return ViewState.AlgoSelection;
		}
		
		
		
	}
		
	private ViewState printAlgoSelection() {
		
		System.out.println("1. Dijkstra");
		System.out.println("2. Prim");
		System.out.print("Choose algorithm: ");
		
		String algo = System.console().readLine();
		System.out.println();
		
		int selection = 0;
		
		try {
			selection = Integer.parseInt(algo);
		} catch (Exception e) {
			System.out.println("Input was not a number!");
			System.out.println("Press Enter to continue...");
			System.console().readLine();
			return ViewState.AlgoSelection;
		}
		
		if(selection == 1)
		{
			algorithm = Algorithm.Dijkstra;
		}
		else if(selection == 2) {
			algorithm = Algorithm.Prim;
		}
		else {
			System.out.println("Input was not 1 or 2!");
			System.out.println("Press Enter to continue...");
			System.console().readLine();
			return ViewState.AlgoSelection;
		}
		
		System.out.println("1. Matrix Priority-First");
		System.out.println("2. List Priority-First");
		System.out.print("Choose type of execution: ");
		
		String type = System.console().readLine();
		System.out.println();
		
		selection = 0;
		
		try {
			selection = Integer.parseInt(type);
		} catch (Exception e) {
			System.out.println("Input was not a number!");
			System.out.println("Press Enter to continue...");
			System.console().readLine();
			return ViewState.AlgoSelection;
		}
		
		if(selection == 1)
		{
			executionType = ExecutionType.Matrix;
		}
		else if(selection == 2) {
			executionType = ExecutionType.List;
		}
		else {
			System.out.println("Input was not 1 or 2!");
			System.out.println("Press Enter to continue...");
			System.console().readLine();
			return ViewState.AlgoSelection;
		}
		
		return ViewState.Graph;
	}
	
	private ViewState printGraph() {
		
		if(algorithm == Algorithm.Dijkstra)
			System.out.print("Executing Dijkstra as ");
		else if(algorithm == Algorithm.Prim)
			System.out.print("Executing Prim as ");
		
		if(executionType == ExecutionType.Matrix)
			System.out.println("Matrix Priority-First");
		else if(executionType == ExecutionType.List)
			System.out.println("List Priority-First");
		
		System.out.println();
		
		if(algorithm == Algorithm.Prim) {			
			if(executionType == ExecutionType.Matrix) {
				MatrixPriorityFirst mpf = new MatrixPriorityFirst();
				
				System.out.println("Befor as adjacency matrix:");
				System.out.println();
				MatrixPriorityFirst.printMatrix(currentGraph.GetAdjacencyMatrix());
				
				System.out.println("After Prim:");
				System.out.println();
				mpf.doPrim(currentGraph.GetAdjacencyMatrix());		
			}
			else if(executionType == ExecutionType.List) {
				
				System.out.println("Befor as list:");
				System.out.println();
				System.out.println(currentGraph);
				System.out.println();
				
				ListPriorityFirst.Prim(currentGraph, 1);
				
				System.out.println("After Prim:");
				System.out.println();
				System.out.println(currentGraph.printPrim());
			}
		}
		else if(algorithm == Algorithm.Dijkstra) {			
			if(executionType == ExecutionType.Matrix) {
				MatrixPriorityFirst mpf = new MatrixPriorityFirst();
				mpf.doDijkstra(currentGraph.GetAdjacencyMatrix());
			}
			else if(executionType == ExecutionType.List) {
				ListPriorityFirst.Dijkstra(currentGraph, 1);
				System.out.println(currentGraph);
			}
		}
		
		System.out.println();
		System.out.println("Press Enter to continue...");
		System.console().readLine();
		return ViewState.Initial;
	}
}
