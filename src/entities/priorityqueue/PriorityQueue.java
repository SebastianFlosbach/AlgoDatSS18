package entities.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {

	private T m_ElementWithHighestPriority;
	
	private List<T> m_Roots;
	
	
	public PriorityQueue() {
		m_Roots = new ArrayList<T>();
	}
	
	
	public boolean IsEmpty() {
		return false;
	}
	
	public void InsertWithPriority(T element, int priority) {
		
	}
	
	public T PullHighestPriorityElement() {
		return null;
	}
	
	public T FindMinimum() {
		return null;
	}
	
}
