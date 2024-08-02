public class StackArray {
    int[] Stack;
    int top;
    int size;
    StackArray(int size)
    {
        this.size=size;
        Stack=new int[size];
        top=-1;
    }
    public void push(int val)
    {
        if(isFull())
        {
            System.out.println("stack is full");
            return;
        }
        Stack[++top]=val;
    }
    public void pop()
    {
        if(isEmpty())
        {
            System.out.println("stack is underFlow");
            return;
        }
        System.out.println("Popped Element is "+ Stack[top--]);
    }
    public boolean isFull()
    {
        return top==size-1;
    }
    public boolean isEmpty()
    {
        return top==-1;
    }
    public void peek()
    {

        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
         System.out.println( Stack[top]);
    }
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty Nothing to display");
            return;
        }
        System.out.println("Stack: ");
        for(int i=0;i<=top;i++)
        {
            System.out.println(Stack[i]+" ");
        }
    }
    public void update(int pos,int val)
    {
        if(pos<0 ||pos>top)
        {
            System.out.println("Unable to insert at this "+ pos+" position");
        }
        Stack[pos]=val;

    }

    public static void main(String[] args) {
        StackArray s=new StackArray(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        // s.push(6);
        // s.pop();
        // s.pop();
        // s.pop();
        // s.pop();
        // s.pop();
        // s.pop();
        s.peek();
        s.display();
    }
}
