class DoubleLinkedList {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;
    }

    DoubleLinkedList() {
        head = null;
    }

    public void insertAtBegin(int val) {
        Node newnode = new Node();
        newnode.data = val;
        newnode.prev = null;
        newnode.next = null;
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            newnode.prev = head.prev;
            head.prev = newnode;
            head = newnode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtEnd(int val) {
        Node newnode = new Node();
        newnode.data = val;
        if (head == null) {
            insertAtBegin(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
        newnode.next = null;
    }

    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            // More than one node
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void insertAtpos(int pos, int val) {
        if (pos == 0) {
            insertAtBegin(val);
            return;
        }
        if (head == null) {
            System.out.println("list is empty unable to insert at position");
            return;
        }
        Node newNode = new Node();
        newNode.data = val;
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
            if (temp == null) {
                System.out.println("unable to insert");
                return;
            }
        }
        if (temp == null) {
            System.out.println("unable to insert");
            return;
        }
        if(temp.next==null)
        {
            newNode.next=temp.next;
            newNode.prev=temp;
            temp.next=newNode;
        }else{
            newNode.next=temp.next;
            newNode.prev=temp;
            temp.next.prev=newNode;
            temp.next=newNode;
        }
    }
    public void deleteAtpos(int pos)
    {
        if (head == null) {
			System.out.println("List is empty, nothing to delete.");
			return;
		}
		if (pos == 0) {
			deleteAtBegin();
			return;
		}
        Node temp=head;
        for(int i=0;i<pos;i++)
        {
            temp=temp.next;
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            // This means we are deleting the head node
            head = temp.next;
        }

    }

}

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.insertAtBegin(3);
        dl.insertAtBegin(2);
        dl.insertAtBegin(1);
        dl.insertAtEnd(4);
        dl.display();
        // dl.deleteAtBegin();
        // dl.deleteAtEnd();
        // dl.insertAtpos(5, 0);
        dl.deleteAtpos(3);
        dl.display();
    }
}
