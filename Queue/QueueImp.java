// Queue using CIrcular Array
public class QueueImp{
    static class Queue {
        int size;
        int front;
        int rear;
        int[] arr;

        Queue(int size) {
            this.size = size;
            this.front = -1;
            this.rear = -1;
            this.arr = new int[size];
        }

        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[front];
            if (front == rear) { // only one element
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }


}