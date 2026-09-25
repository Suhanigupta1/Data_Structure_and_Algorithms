//stack using Linked List
public class StackLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        public static Node head = null;
        public static void push(int data) {
            Node newNode = new Node(data);

            if(head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static boolean isEmpty() {
            return head == null;
        }

        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            Node top = head;
            head = head.next;
            return top.data;
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            Node top = head;
            return top.data;
        }
    }
    public static void pushatBottom(int data, Stack Stack) {
        if(Stack.isEmpty()) {
            Stack.push(data);
            return;
        }
        int top = Stack.pop();
        pushatBottom(data, Stack);
        Stack.push(top);
    }

    public static void reverse(Stack Stack) {
        if(Stack.isEmpty()) {
            return;
        }
        int top = Stack.pop();
        reverse(Stack);
        pushatBottom(top, Stack);
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        pushatBottom(5, stack);
        // reverse(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}