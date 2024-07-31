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
    public void display()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        else{
            Node temp=head;
            while(temp!=null)
            {
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
        }
        System.out.println("null\n");
    }
    public void insertAtEnd(int val)
    {
        Node newnode=new Node();
        if(head==null)
        {
            insertAtBegin(val);
            return;
        }
        else{
            newnode.data=val;
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.next=null;
        }
    }

}

public class Demo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();// object creation
        // ll.insertAtBegin(3);
        // ll.insertAtBegin(2);
        // ll.insertAtBegin(1);
        // ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(4);
        ll.display();
    }
}
