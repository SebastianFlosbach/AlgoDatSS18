package entities.priorityqueue;

class PriorityQueueElement {
	
	private Object m_Element;
	private float m_Priority;
	
	public Object GetElement() {
		return m_Element;
	}
	
	public float GetPriority() {
		return m_Priority;
	}
	
	public void SetPriority(float _priority) {
		m_Priority = _priority;
	}
	
	public PriorityQueueElement(Object _element, float _priority) {
		m_Element = _element;
		m_Priority = _priority;
	}
		
}
