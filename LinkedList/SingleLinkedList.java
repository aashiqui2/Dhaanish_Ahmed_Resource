package LinkedList;
class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;
    }

    // constructor-constructor name should be same name as class name,
    // no return type
    LinkedList() {
        head = null;
    }

    public void insertAtBegin(int val) {
        Node newnode = new Node();
        if (head == null) {
            newnode.data = val;
            newnode.next = null;
            head = newnode;
        } else {
            newnode.data = val;
            newnode.next = head;
            head = newnode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
        }
        System.out.println("null\n");
    }

    public void insertAtEnd(int val) {
        Node newnode = new Node();
        if (head == null) {
            insertAtBegin(val);
            return;
        } else {
            newnode.data = val;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.next = null;
        }
    }

    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            head = head.next;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void insertAtpos(int pos,int val) {
        if(pos==0)
        {
            insertAtBegin(0);
        }
        Node newnode=new Node();
        Node temp=head;
        for(int i=0;i<pos-1;i++)
        {
            temp=temp.next;
            
        }
        if(temp==null)
            {
                System.out.println("Index out of bounds");
                return;
            }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public void deleteAtpos(int pos)
    {
        if(pos==0)
        {
            deleteAtBegin();
            return;
        }
        Node temp=head;
        Node prev=null;
        for(int i=0;i<pos;i++)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp==null)
        {
            System.out.println("INVALID Position");
            return;
        }
        prev.next=temp.next;
    }
    public void count()
    {
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        System.out.println("No of Nodes"+ count);
    }

}

public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();// object creation
        ll.insertAtBegin(3);
        ll.insertAtBegin(2);
        ll.insertAtBegin(1);
        ll.insertAtEnd(4);
        ll.insertAtpos(5, 0);
        ll.deleteAtpos(4);
        ll.count();

        // ll.deleteAtBegin();
        // ll.deleteAtEnd();
        ll.display();
    }
}
