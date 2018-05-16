package entities.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {

	private PriorityQueueElement<T> m_ElementWithHighestPriority;
	
	private List<PriorityQueueElement<T>> m_Roots;
	
	
	public PriorityQueue() {
		m_Roots = new ArrayList<PriorityQueueElement<T>>();
	}
	
	
	public boolean IsEmpty() {
		return false;
	}
	
	public void InsertWithPriority(T element, int priority) {
		PriorityQueueElement<T> newElement = new PriorityQueueElement<T>(element, priority, null, null);
		m_Roots.add(newElement);
	}
	
	public T GetHighestPriorityElement() {
		return m_ElementWithHighestPriority.GetElement();
	}
	
	public T PullHighestPriorityElement() {
		T element = m_ElementWithHighestPriority.GetElement();	
		m_Roots.remove(m_ElementWithHighestPriority);
		
		for(PriorityQueueElement<T> children : m_ElementWithHighestPriority)
		
		return null;
	}
	
}
