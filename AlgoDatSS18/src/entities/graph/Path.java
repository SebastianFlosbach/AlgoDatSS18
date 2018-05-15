package entities.graph;

import java.util.ArrayList;
import java.util.List;

public class Path {
	
	private List<Integer> m_PathIds;
	
	public List<Integer> GetPathIds(){
		return m_PathIds;
	}
	
	public Path() {
		m_PathIds = new ArrayList<Integer>();
	}
	
	public void AddWaypoint(int id) {
		m_PathIds.add(id);
	}
	
	public void ChangeLastWaypoint(int id) {
		if(m_PathIds.isEmpty())
			return;
		
		m_PathIds.set((m_PathIds.size() - 1), id);
	}
	
}
