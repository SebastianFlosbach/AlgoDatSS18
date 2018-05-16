package entities.priorityqueue;

import java.util.List;

class PriorityQueueElement<T> {
	
	private T m_Element;
	
	private int m_Priority;
	
	private boolean m_IsRoot;
	
	private PriorityQueueElement<T> m_Parent;
	private List<PriorityQueueElement<T>> m_Children;
	
	public T GetElement() {
		return m_Element;
	}
	
	public void SetPreviousElement(PriorityQueueElement<T> element) {
		m_Parent = element;
		
		if(element == null)
			m_IsRoot = true;
	}

	public void SetNextElement(PriorityQueueElement<T>... elements) {
		for(PriorityQueueElement<T> nextElement : elements)
			m_Children.add(nextElement);
	}
	
	public boolean IsRoot() {
		return m_IsRoot;
	}
	
	
	public PriorityQueueElement(T element, int priority, PriorityQueueElement<T> _parent, PriorityQueueElement<T>... _children) {
		m_Element = element;
		
		m_Priority = priority;
		
		m_Parent = _parent;
		
		for(PriorityQueueElement<T> child : _children)
			m_Children.add(child);
		
		if(_parent == null)
			m_IsRoot = true;
		else
			m_IsRoot = false;
	}
	
	
	public void Remove() {
		if(m_Parent != null) {
			m_Parent.SetNextElement(m_Children);
		}			
		else {
			m_Children.SetPreviousElement(null);
		}
		
		if(m_Children != null) {
			m_Children.SetPreviousElement(m_Parent);
		}
									
	}
	
}
