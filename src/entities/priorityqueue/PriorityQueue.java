package entities.priorityqueue;

import java.util.Arrays;

import entities.*;

public class PriorityQueue<T extends QueueElement> {
	
	private PriorityQueueElement[] m_Queue;
	private int[] m_Position;;
	
	private int nextElementId = 0;
	
	public boolean IsEmpty() {
		return true;
	}
	
	public PriorityQueue(int _size) {
		m_Queue = new PriorityQueueElement[_size];
		m_Position = new int[_size];
		Arrays.fill(m_Position, -1);
	}
	
	public void Insert(T _element, float _priority) {
		
		if(_element.GetQueueId() == -1 || m_Position[_element.GetQueueId()] == -1) {
			
			_element.SetQueueId(nextElementId);
			
			PriorityQueueElement pqElement = new PriorityQueueElement(_element, _priority);
			
			m_Queue[nextElementId] = pqElement;
			
			upHeap(nextElementId);
			
			nextElementId++;
		}		
	}
	
	public boolean Update(QueueElement _element, float _priority) {
		
		if(m_Queue[m_Position[_element.GetQueueId()]].GetPriority() > _priority) {
			m_Queue[m_Position[_element.GetQueueId()]].SetPriority(_priority);
			upHeap(m_Position[_element.GetQueueId()]);
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T Extract() {
		T result = (T)m_Queue[0].GetElement();
		
		m_Position[result.GetQueueId()] = -1;
		
		PriorityQueueElement newestElement = m_Queue[nextElementId - 1];
		
		m_Queue[0] = newestElement;
		
		m_Position[((T)newestElement.GetElement()).GetQueueId()] = 0;
		
		nextElementId--;
		
		return result;
	}
	
	private void upHeap(int index) {
		int j = index / 2;
		PriorityQueueElement pqElement = m_Queue[index];
		
		while(j <= 1) {
			if(pqElement.GetPriority() <= m_Queue[j].GetPriority())
				break;
			
			m_Queue[index] = m_Queue[j];
			index = j;
			j = index / 2;
		}
		
		m_Queue[index] = pqElement;
	}
	
	private void downHeap(int index) {
	}
	
}
