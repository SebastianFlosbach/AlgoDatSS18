package entities.priorityqueue;

class PriorityQueueElement<T> {
	
	private T m_Element;
	
	private int m_Priority;
	
	private boolean m_IsRoot;
	
	private PriorityQueueElement<T> m_PreviousElement;
	private PriorityQueueElement<T> m_NextElement;
	
	public void SetPreviousElement(PriorityQueueElement<T> element) {
		m_PreviousElement = element;
		
		if(element == null)
			m_IsRoot = true;
	}
	
	public boolean IsRoot() {
		return m_IsRoot;
	}
	
	public void SetNextElement(PriorityQueueElement<T> element) {
		m_NextElement = element;
	}
	
	
	public PriorityQueueElement(T element, int priority, PriorityQueueElement<T> previous, PriorityQueueElement<T> next) {
		m_Element = element;
		
		m_Priority = priority;
		
		m_PreviousElement = previous;
		m_NextElement = next;
		
		if(previous == null)
			m_IsRoot = true;
		else
			m_IsRoot = false;
	}
	
	
	public void Remove() {
		if(m_PreviousElement != null) {
			m_PreviousElement.SetNextElement(m_NextElement);
		}			
		else {
			m_NextElement.SetPreviousElement(null);
		}
		
		if(m_NextElement != null) {
			m_NextElement.SetPreviousElement(m_PreviousElement);
		}
									
	}
	
}
