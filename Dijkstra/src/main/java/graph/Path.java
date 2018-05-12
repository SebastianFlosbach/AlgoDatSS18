package main.java.graph;

import java.util.ArrayList;

public class Path {
	
	ArrayList<Integer> PathIds;
	
	public Path() {
		PathIds = new ArrayList<Integer>();
	}
	
	public void AddWaypoint(int id) {
		PathIds.add(id);
	}
	
}
