package presentation;

import business.algorithm.MatrixPriorityFirst;

public class Main {

	public static void main(String[] args) {
		
		if(args != null && args.length > 0) {
			GraphTester tester = new GraphTester(args[0]);
			
			tester.Run();
		}
		else {
			System.out.println("Missing argument: Path to graphs!");
		}

		/*int[][] matrix = new int[][]{{0,2,0,6,0},{2,0,0,8,0},{0,0,0,0,7},{6,8,0,0,0},{0,0,7,0,0}};

		MatrixPriorityFirst mpf = new MatrixPriorityFirst();
		mpf.doPrim(matrix);
		mpf.doDijkstra(matrix);*/
		
		
		
	}
	
	

}
