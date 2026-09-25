class Reverse_Linked_List {
    Node head; // head of the linked list

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Reverse_Linked_List list = new Reverse_Linked_List();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(list.head);

        list.head = list.reverse(list.head);

        System.out.println("Reversed Linked List:");
        printList(list.head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}