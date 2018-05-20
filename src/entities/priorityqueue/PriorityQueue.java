package entities.priorityqueue;

import entities.*;

public class PriorityQueue<T extends QueueElement> {
	
	private PriorityQueueElement[] m_Queue;
	private int[] m_Position;;
	
	private int lastElementId = 0;
	
	public boolean IsEmpty() {
		return true;
	}
	
	public PriorityQueue(int _size) {
		m_Queue = new PriorityQueueElement[_size + 1];
		m_Position = new int[_size + 1];
	}
	
	public void Insert(T _element, float _priority) {
		lastElementId++;
		_element.SetQueueId(lastElementId);
		
		PriorityQueueElement pqElement = new PriorityQueueElement(_element, _priority);
		
		m_Queue[lastElementId] = pqElement;
		m_Position[lastElementId] = lastElementId;
		
		upHeap(lastElementId);
	}
	
	public boolean Update(QueueElement _element, float _priority) {
		
	}
	
	public T Extract() {
		
	}
	
	private void upHeap(int index) {
		int parentIndex = index / 2;
		
		PriorityQueueElement upElement = m_Queue[index];
		PriorityQueueElement parentElement;
		
		while(parentIndex >= 0) {
			
			parentElement = m_Queue[parentIndex];
			
			if(upElement.GetPriority() <= parentElement.GetPriority())
				break;
			
			m_Queue[index] = parentElement;
			m_Position[((T)parentElement.GetElement()).GetQueueId()] = index;
			
			index = parentIndex;
			parentIndex = index / 2;
		}
		
		m_Queue[index] = upElement;
		m_Position[((T)upElement.GetElement()).GetQueueId()] = index;
	}
	
	private void downHeap(int index) {
		int smallestElementIndex = index;
		
		int leftChildIndex = 2 * index;
		int rightChildIndex = 2 * index + 1;
		
		
		if(leftChildIndex < m_Queue.length) {			
			if(m_Queue[leftChildIndex].GetPriority() < m_Queue[smallestElementIndex].GetPriority()) {
				smallestElementIndex = leftChildIndex;
			}
		}
		
		if(rightChildIndex < m_Queue.length) {
			if(m_Queue[rightChildIndex].GetPriority() < m_Queue[smallestElementIndex].GetPriority()) {
				smallestElementIndex = rightChildIndex;
			}
		}
		
		if(smallestElementIndex != index) {
			PriorityQueueElement swapElement = m_Queue[index];
			m_Queue[index] = m_Queue[smallestElementIndex];
			m_Queue[smallestElementIndex] = swapElement;
			m_Position[((T)m_Queue[index].GetElement()).GetQueueId()] = index;
			m_Position[((T)m_Queue[smallestElementIndex].GetElement()).GetQueueId()] = smallestElementIndex;		

			downHeap(smallestElementIndex);
		}	
	}
	
}
