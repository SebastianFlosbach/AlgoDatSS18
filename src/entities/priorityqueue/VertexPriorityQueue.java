package entities.priorityqueue;

import entities.graph.Vertex;

public class VertexPriorityQueue {
	
	private Vertex[] m_VertexHeap;
	
	// Positions of vertices
	private int[] m_Position;
	
	private int m_CurrentIndex = 0;
	private int m_HeapSize;
	
	/**
	 * 
	 * @return True if this queue contains no items
	 */
	public boolean IsEmpty() {
		return m_CurrentIndex == 0;
	}
	
	public int GetHeapSize() {
		return m_HeapSize;
	}
	
	
	public VertexPriorityQueue(int _size) {
		m_HeapSize = _size;
		
		// _size + 1 because the heap starts at index 1
		m_VertexHeap = new Vertex[_size + 1];
		m_Position = new int[_size + 1];
	}
	
	
	/**
	 * Get heap position of a vertex
	 * @param _vertex Vertex inside the heap
	 * @return The heap position > 0, otherwise 0
	 */
	private int getVertexPosition(Vertex _vertex) {
		if(_vertex != null && _vertex.GetId() <= m_HeapSize)		
			return m_Position[_vertex.GetId()];
		
		return 0;
	}
	
	private void upHeap(int _index) {
		
		if(m_VertexHeap[_index] == null)
			return;
		
		// Floor of _index / 2 is the parent index
		int parentIndex = _index / 2;
		
		Vertex upVertex = m_VertexHeap[_index];
		
		while(parentIndex > 0) {
			
			// If current vertex has a lower priority than its parent swap them
			if(m_VertexHeap[_index].GetDistance() < m_VertexHeap[parentIndex].GetDistance()) {
				updateVertexPosition(parentIndex, _index);
				updateVertexPosition(upVertex, parentIndex);
				
				// Move indices one layer up
				_index = parentIndex;
				parentIndex = _index / 2;
			}
			else {
				break;
			}				
		}		
		
	}
	
	private void downHeap(int _index) {
		Vertex parentVertex = m_VertexHeap[_index];
		int smallestChildIndex = _index;
		
		int leftChildIndex = _index * 2;
		int rightChildIndex = _index * 2 + 1;
		
		if(leftChildIndex < m_HeapSize && m_VertexHeap[leftChildIndex] != null) {
			if(m_VertexHeap[leftChildIndex].GetDistance() < m_VertexHeap[smallestChildIndex].GetDistance()) {
				smallestChildIndex = leftChildIndex;
			}
		}
		
		if(rightChildIndex < m_HeapSize && m_VertexHeap[rightChildIndex] != null) {
			if(m_VertexHeap[rightChildIndex].GetDistance() < m_VertexHeap[smallestChildIndex].GetDistance()) {
				smallestChildIndex = rightChildIndex;
			}
		}
		
		if(smallestChildIndex != _index) {
			updateVertexPosition(smallestChildIndex, _index);
			updateVertexPosition(parentVertex, smallestChildIndex);
			
			downHeap(smallestChildIndex);
		}
	}
	
	/**
	 * Change vertex position in the heap and update its position in the position array
	 * @param _vertex Vertex to update
	 * @param _position New position inside the vertexHeap
	 */
	private void updateVertexPosition(Vertex _vertex, int _newPosition) {
		if(_vertex == null || _newPosition < 1 || _newPosition > m_HeapSize)
			return;
		
		// Clear old position of vertex inside heap
		m_VertexHeap[getVertexPosition(_vertex)] = null;
		// Reset position of vertex at new position
		if(m_VertexHeap[_newPosition] != null)
			m_Position[m_VertexHeap[_newPosition].GetId()] = 0;
		// Place vertex at new position
		m_VertexHeap[_newPosition] = _vertex;
		// Update position of vertex
		m_Position[_vertex.GetId()] = _newPosition;
	}
	
	/**
	 * Change vertex position in the heap and update its position in the position array
	 * @param _oldPosition Current position inside the vertexHeap
	 * @param _newPosition New position inside the vertexHeap
	 */
	private void updateVertexPosition(int _oldPosition, int _newPosition) {
		if(_newPosition < 1 || _newPosition > m_HeapSize)
			return;
		
		if(_oldPosition < 1 || _oldPosition > m_HeapSize)
			return;
		
		if(m_VertexHeap[_oldPosition] == null)
			return;
		
		Vertex vertex = m_VertexHeap[_oldPosition];
		updateVertexPosition(vertex, _newPosition);
	}
	
	/**
	 * Insert a new Vertex into the queue
	 * @param _vertex Vertex to be inserted
	 * @return True if insertion was successful
	 */
	public boolean Insert(Vertex _vertex) {
		
		if(_vertex == null || m_CurrentIndex >= m_HeapSize || getVertexPosition(_vertex) != 0)
			return false;
		
		m_CurrentIndex++;
		
		m_VertexHeap[m_CurrentIndex] = _vertex;
		m_Position[_vertex.GetId()] = m_CurrentIndex;
		
		upHeap(m_CurrentIndex);
		
		return true;
	}
	
	/**
	 * Update the queue after a vertex has changed
	 * @param _vertex Vertex that changed
	 * @return True if update was successful
	 */
	public boolean Update(Vertex _vertex, float _value) {
		
		if(getVertexPosition(_vertex) > 0) {
			m_VertexHeap[getVertexPosition(_vertex)].SetDistance(_value);
			upHeap(getVertexPosition(_vertex));
			return true;
		}
		
		return false;
	}
	
	public Vertex Peek() {
		return m_VertexHeap[1];
	}
	
	/**
	 * Get top element of the queue
	 * @return Vertex with minimum distance to source
	 */
	public Vertex Pull() {
		
		Vertex pullVertex = m_VertexHeap[1];
		
		if(pullVertex == null)
			return null;
		
		updateVertexPosition(m_CurrentIndex, 1);
		m_VertexHeap[m_CurrentIndex] = null;
		m_Position[pullVertex.GetId()] = 0;
		
		downHeap(1);
		
		m_CurrentIndex--;
		
		return pullVertex;
	}
	
}
