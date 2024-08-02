class CircularLinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	CircularLinkedList() {
		head = null;
	}

	// Insert at the beginning
	public void insertAtBeginning(int val) {
		Node newnode = new Node(val);
		if (head == null) {
			head = newnode;
			head.next = head;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			newnode.next = head;
			temp.next = newnode;
			head = newnode;
		}
	}

	// Delete at the beginning
	public void deleteAtBeginning() {
		if (head == null) {
			System.out.println("List is empty, nothing to delete.");
			return;
		}
		if (head.next == head) { // Only one node
			head = null;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = head.next;
			head = head.next;
		}
	}

	// Insert at the end
	public void insertAtEnd(int val) {
		Node newnode = new Node(val);
		if (head == null) {
			head = newnode;
			head.next = head;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newnode;
			newnode.next = head;
		}
	}

	// Delete at the end
	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("List is empty, nothing to delete.");
			return;
		}
		if (head.next == head) { // Only one node
			head = null;
		} else {
			Node temp = head;
			Node prev = null;
			while (temp.next != head) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = head;
		}
	}

	// Insert at a specific position
	public void insertAtPos(int pos, int val) {
		Node newnode = new Node(val);
		if (pos == 0) {
			insertAtBeginning(val);
			return;
		}
		Node temp = head;
		for (int i = 0; i < pos - 1; i++) {
			if (temp.next == head) {
				System.out.println("Position is out of bounds, unable to insert.");
				return;
			}
			temp = temp.next;
		}
		newnode.next = temp.next;
		temp.next = newnode;
	}

	// Delete at a specific position
	public void deleteAtPos(int pos) {
		if (head == null) {
			System.out.println("List is empty, nothing to delete.");
			return;
		}
		if (pos == 0) {
			deleteAtBeginning();
			return;
		}
		Node temp = head;
		Node prev = null;
		for (int i = 0; i < pos; i++) {
			if (temp.next == head) {
				System.out.println("Position is out of bounds, unable to delete.");
				return;
			}
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}

	// Search for a value
	public int search(int val) {
		if (head == null) {
			return -1;
		}
		Node temp = head;
		int pos = 0;
		do {
			if (temp.data == val) {
				return pos;
			}
			temp = temp.next;
			pos++;
		} while (temp != head);
		return -1;
	}

	// Count the number of nodes
	public int count() {
		if (head == null) {
			return 0;
		}
		Node temp = head;
		int count = 0;
		do {
			count++;
			temp = temp.next;
		} while (temp != head);
		return count;
	}

	// Display the value at a specific position
	public void displayPosition(int pos) {
		if (head == null) {
			System.out.println("List is empty, nothing to display at position " + pos);
			return;
		}
		Node temp = head;
		for (int i = 0; i < pos; i++) {
			if (temp.next == head) {
				System.out.println("Position is out of bounds, unable to display.");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Value at position " + pos + " is: " + temp.data);
	}

	// Update the value at a specific position
	public void updateData(int pos, int val) {
		if (head == null) {
			System.out.println("List is empty, nothing to update at position " + pos);
			return;
		}
		Node temp = head;
		for (int i = 0; i < pos; i++) {
			if (temp.next == head) {
				System.out.println("Position is out of bounds, unable to update.");
				return;
			}
			temp = temp.next;
		}
		temp.data = val;
	}

	// Display the entire list
	public void display() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != head);
		System.out.println();
	}
}

public class CircularLinkedListDemo{

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtBeginning(3);
        cll.insertAtBeginning(2);
        cll.insertAtBeginning(1);
        cll.insertAtEnd(4);
        cll.insertAtPos(2, 5);
        cll.display(); // Output: 1 2 5 3 4

        cll.deleteAtPos(2);
        cll.display(); // Output: 1 2 3 4

        cll.deleteAtBeginning();
        cll.display(); // Output: 2 3 4

        cll.deleteAtEnd();
    }
}
