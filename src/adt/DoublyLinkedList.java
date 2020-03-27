package adt;

public class DoublyLinkedList<Type> extends ADT<Type> {

	// Create sub class node
	class node<DataType> {
		// Node Attributes
		public node<DataType> next;
		public node<DataType> prev;
		public DataType data;
		
		// init node
		public node(DataType data) { this.data = data; }
	}
	
	// DoublyLinkedList Attributes
	// Records head and tail
	public node<Type> nill;

	
	// Constructor
	public DoublyLinkedList() {
		super();
		nill = new node<Type>(null);
		nill.next = nill;
		nill.prev = nill;
		nill.data = null;
	}
	
	// Add implementation
	// If present, return false, else return true
	public boolean Add(Type data) {
		
		// Create a new node
		node<Type> n = new node<Type>(data);
		
		if (IsElement(data).data == null) {
			n.next = nill.next;
			nill.next.prev = n;
			nill.next = n;
			n.prev = nill;
			setSize += 1;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Remove(Type data) {
		// Check is data is in list
		node<Type> n = IsElement(data);
			
		if (n.data != null) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
			setSize -= 1;
			return true;
		} else {
			return false;
		}
		
	}
	
	public node<Type> IsElement(Type data) {
		// Get head node
		node<Type> x = nill.next;
		// Traverse list
		while (x != nill && !data.equals(x.data)) {
			x = x.next;
		}
		return x;
	}
	
	public boolean SetEmpty() {
		return (setSize == 0) ? true : false;
	}
	
	public int SetSize() {
		return setSize;
	}
	
	public DoublyLinkedList<Type> Union(DoublyLinkedList<Type> T) {
		DoublyLinkedList<Type> unionSet = this;
		// Get head node
		node<Type> x = T.nill.next;
		// Traverse list
		while (x != T.nill) {
			if (unionSet.IsElement(x.data).data == null) {
				unionSet.Add(x.data);
			}		
			x = x.next;
		}
		return unionSet;
	}
	
	public DoublyLinkedList<Type> Intersection(DoublyLinkedList<Type> T) {
		DoublyLinkedList<Type> interSet = new DoublyLinkedList<Type>();
		// Get head node
		node<Type> x = T.nill.next;
		// Traverse list
		while (x != T.nill) {
			if (this.IsElement(x.data).data != null) {
				interSet.Add(x.data);
			}		
			x = x.next;
		}
		return interSet;
	}
	
	public DoublyLinkedList<Type> Difference(DoublyLinkedList<Type> T) {
		DoublyLinkedList<Type> diffSet = this;
		// Get head node
		node<Type> x = T.nill.next;
		// Traverse list
		while (x != T.nill) {
			if (this.IsElement(x.data).data != null) {
				diffSet.Remove(x.data);
			}		
			x = x.next;
		}
		return diffSet;
	}
	
	public boolean IsSubsetOf(DoublyLinkedList<Type> T) {
		// Get head node
		node<Type> x = this.nill.next;
		
		while (x != this.nill) {
			if (T.IsElement(x.data).data == null) {
				return false;
			}		
			x = x.next;
		}
		
		return true;
	}
	
	
	public void PrintList() {
		node<Type> currentNode = nill.next;
		while (currentNode.data != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}		
	}

	public static void main(String args[]) {
		
		DoublyLinkedList<Integer> ints = new DoublyLinkedList<Integer>();
		DoublyLinkedList<String> strings2 = new DoublyLinkedList<String>();
		
		ints.Add(44);
		ints.Add(44);
		ints.Add(1000);
		ints.Add(1000);
		ints.PrintList();
		
		
	}

}
