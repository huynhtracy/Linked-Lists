
public class LinkedList {

	private Node head; 
	private Node tail; 
	private int length;
	
	//constructor 1: generates a linked lists and populates the first element (head)
	public LinkedList (Node head) {
		head = head;
		tail = head; 
		length = 1;
	}
	
	//constructor 2: generates empty linked list
	public LinkedList() {
		length = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void appendFront(int value) {
		Node node = new Node (value);

		if (isEmpty()) {
			head = node;
			tail = node;
		}
		else {
			node.next = head;
			head = node; 
		}
		length++;
	}
	
	
	public void appendBack(int value) {
		Node node = new Node (value);
		
		if (isEmpty()) {
			head = node;
			tail = node; 
		}
		else {
			node.next = null;
			tail.next = node; 
			tail = node; 
		}
		length++;
	
	}
	
	public void removeFirstOccurence(int value) {
		
		if (isEmpty()) {
			return;
		}
		else if (head.value == value) {
			head = head.next;
		}
		else {	
			Node current = head;		
			while (current.next != null) {
				if (current.next.value == value) {
					//change the pointer to skip this node
					current.next = current.next.next;	
					length--;
					break; 
				}
				current = current.next;
			}
			
		
		}
	}
	
	public void removeAll(int value) {
		
		if (isEmpty()) {
			return;
		}
		
			
		Node current = head;		
		while (current.next != null) {
			if (current.next.value == value) {
				current.next = current.next.next;
			}
			else {
				current = current.next;	
				}
			}
		
		if (head.value == value) {
			head = head.next;
		}
		
			
	}
		

	public boolean contains(int value) {
		if (isEmpty()) {
			return false; 
		}
		if (head.value == value) {
			return true;
		}
		
		Node current = head; 
		
		while (current.next != null) {
			if (current.next.value == value) {
				return true;
			}
			current = current.next;
		}
		
		/*
		if (tail.value == value) {
			return true;
		}
		*/
		
		return false;
		
	}
	
	public int getLength() {
		
		if(isEmpty()) {
			return 0;
		}
		if (head == tail) {
			return 1;
		}
		
		int count = 0; 
		Node current = head; 
		while(current.next != null) {
			count++;
			current = current.next; 
		}
		return count +1;
	}
	

	
	public void insertAt(int value, int index) {
			
			if (index == 0) {
				appendFront(value);
			}
			else {
				
				Node leftNode =head;
				Node rightNode = head; 
				
				for (int i = 0; i < index; i++) {
					rightNode = rightNode.next;	
					if (i > 0) {
						leftNode = leftNode.next;
					}
				}
				
				Node node= new Node(value);
				
				leftNode.next = node; 
				node.next = rightNode;
				
			}
		
	}
	
	public void reverse2() {
		//another implementation
		if(isEmpty() || head.next == null) {
			return;
		}
		
		Node current = head.next;
		Node prev = head;
		Node temp;
		prev.next = null;
		while(current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		temp = head;
		head = tail;
		tail = temp;
	}
	
	public LinkedList reverse() {
		Node current = head;
		LinkedList newList = new LinkedList();
		newList.appendBack(head.value);
		while (current.next != null) {
			//make a new linked list and populate it
			//append front will make it reverse
			newList.appendFront(current.next.value);
			current = current.next;
		}
		this.tail  = head;
		this.head = current;
		
		return newList;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("[]");
		}
		else {
			String s = "[";
			Node current = head;
			while (current.next != null) {
				
				s+= current.value + " -> ";
				current = current.next;
			}
			s += current.value + "]";
			System.out.println(s);
		}
	}
	
	
	/*
	public void appendBack(int value) {
		Node node = new Node (value);
		if (isEmpty()) {
			head = node; 
		}
		else {
			Node current = head; 
			while (current.next != null) {
				//while there is something it is pointing to enter loop
				current = current.next;
			}
			//when we get here, current.next = null
			//so we can append it here
			current.next = node;
		}
	}
	*/
	
	
}
