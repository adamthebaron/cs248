public class QueueLL implements queue {
	private class node {
		public Object item;
		public node next;
	}
	
	node front, back;
	int count;
	
	public QueueLL() {
		count = 0;
		front= back = null;
	}
	
	public void enqueue(Object obj) {
		node newnode = new node();
		newnode.item = obj;
		newnode.next = null;
		
		if (back == null)
			front = newnode;
		
		else
			back.next = newnode;
		
		back = newnode;
		count++;
	}
	public Object dequeue() {
		if (isEmpty()) 
			return null;
		
		Object saveditem = front.item;
		front = front.next;
		count--;
		
		if (front == null) 
			back = null;
		
		return saveditem;
	}
	
	public Object getFront() {
		if (isEmpty()) 
			return null;
		return front.item;
	}
	
	public int sizeOf() { 
		return count;
	}
	public boolean isEmpty() { 
		return count <= 0; 
	}
	public boolean isFull() { 
		return false; 
	}
	public void makeEmpty() {
		count = 0;
		front = back = null;		
	}
}