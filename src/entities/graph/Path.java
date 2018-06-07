package entities.graph;

import java.util.ArrayList;
import java.util.List;

public class Path {
	
	private List<Vertex> m_PathIds;
	
	public List<Vertex> GetPathIds(){
		return m_PathIds;
	}
	
	public Path() {
		m_PathIds = new ArrayList<Vertex>();
	}
	
	public void AddWaypoint(Vertex _vertex) {
		m_PathIds.add(_vertex);
	}
	
	@Override
	public String toString() {
		
		String path = "";
		
		for(Vertex waypoint : m_PathIds) {
			path += waypoint + "\n";
		}
		
		return path;
	}
	
}
