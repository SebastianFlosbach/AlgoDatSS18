package presentation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public GraphTester(String _pathToGraphs) {
		m_PathToGraphs = _pathToGraphs;
	}
	
	public void Run() {
		
		boolean isRunning = true;
		ViewState viewState = ViewState.Initial;
		
		while(isRunning) {
			clearConsole();
			
			printHeader();
			
			switch (viewState) {
			case Initial:
				printInitial();
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
	}
	
	private void printHeader() {
		System.out.println("Djikstra/Prim Test Program");
		System.out.println("--------------------------");
		System.out.println();
	}
	
	private void printInitial() {
		System.out.println("Available graphs:");
		
		for(File graphFile : GetListOfGraphs()) {
			System.out.println("\t" + graphFile.getName());
		}
		
		System.out.println();
		System.out.print("Select graph: ");
		
		String input = System.console().readLine();
		
		
	}
	
}
