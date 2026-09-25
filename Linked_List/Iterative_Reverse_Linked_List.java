class Iterative_Reverse_Linked_List {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void reverse(Node head) {
        if (head == null || head.next == null) {
            return ;
        }
        Node prev = head;
        Node current = head.next;
        Node nextNode = null; 
        while (current != null) {
            nextNode = current.next; 
            current.next = prev; 
            prev = current; 
            current = nextNode; 
        }
        head.next = null;
        head = prev;

    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Iterative_Reverse_Linked_List list = new Iterative_Reverse_Linked_List();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        list.printList(list.head);
        list.reverse(list.head);

        System.out.println("\nReversed Linked List:");
        list.printList(list.head);
    }
}