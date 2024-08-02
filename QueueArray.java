public class QueueArray {
    private int[] queue;
    private int front, rear, capacity;

    QueueArray(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    // Method to add an element to the queue (enqueue)
    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        queue[rear++] = val;
    }

    // Method to remove an element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return Integer.MIN_VALUE;
        }
        int data = queue[front];
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        return data;
    }

    // Method to get the front element of the queue without removing it (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return Integer.MIN_VALUE;
        }
        return queue[front];
    }

    // Method to update an element at a specific index in the queue
    public void update(int index, int newValue) {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        if (index < 0 || index >= rear) {
            System.out.println("Invalid index.");
            return;
        }
        queue[index] = newValue;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == rear;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return rear == capacity;
    }

    // Method to display the contents of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        
        q.display(); // Display the queue

        q.dequeue();
        q.display(); // Display the queue after dequeue

        System.out.println("Front element is: " + q.peek());
        System.out.println("Is the queue empty? " + q.isEmpty());
        System.out.println("Is the queue full? " + q.isFull());

        q.update(1, 99); // Update the second element
        q.display(); // Display the queue after update
    }
}
