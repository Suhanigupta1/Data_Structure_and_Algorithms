// Queue using Linked List
public class QueueImp2 { 
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {
        Node front;
        Node rear;

        Queue() {
            this.front = null;
            this.rear = null;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = front.data;
            front = front.next;
            if (front == null) { // If the queue becomes empty
                rear = null;
            }
            return data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}