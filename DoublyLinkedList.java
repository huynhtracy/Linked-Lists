
public class DoublyLinkedList {
	
	private DoubleNode head; 
	private DoubleNode tail; 
	
	public DoublyLinkedList(DoubleNode head) {
		this.head = head;
		this.tail = head;
	}
	
	public DoublyLinkedList() {
		
	}
	
	public boolean isEmpty() {
		return head == null; 
	}
	
	public void appendFront(int value) {
		DoubleNode node = new DoubleNode(value);
		node.next = head;
		head.prev = node;
		head = node; 
	}
	
	public void appendBack(int value) {
		DoubleNode node = new DoubleNode(value);
		node.prev = tail;
		tail.next = node;
		tail = node;
		
	}
	
	public void insertAt(int value, int index) {
		
		if (index == 0) {

			appendFront(value);
		}
		else {
			
			DoubleNode leftNode;
			DoubleNode rightNode = head; 
			
			for (int i = 0; i < index; i++) {
				rightNode = rightNode.next;		
			}
			leftNode = rightNode.prev;
			
			if (rightNode == tail) {
				appendBack(value);
			}
			
			DoubleNode node= new DoubleNode(value);
			leftNode.next = node;
			node.prev = leftNode;
			rightNode.prev = node;
			node.next = rightNode; 
			
		}

	}
	
	public DoublyLinkedList merge(DoublyLinkedList secondList) {
		int last = 0; 
		
		DoubleNode current = head; 
		DoubleNode current2 = secondList.head;
		DoublyLinkedList newList = new DoublyLinkedList();
		newList.appendBack(current.value);
		newList.appendBack(current2.value);

		while (current.next != null && current2.next != null) {

				newList.appendBack(current.next.value);
				newList.appendBack(current2.next.value);
				
		}
	
		while (current.next != null) {
			newList.appendBack(current.next.value);
		}
		while (current2.next != null) {
			newList.appendBack(current2.next.value);
		}
		
		return newList; 
	}
	
	public void print() {
		
		if(isEmpty()) {
			System.out.println("[]");
		}
		else {
			String s = "[";
			DoubleNode current = head;
			while(current.next != null) {
				s+= current.value + " <--> ";
				current = current.next;
			}
			s += current.value + "]";
			System.out.println(s);
		}
		
	}

}
