package LinkedList;

public class LinkedList {
    Node head;

    // Linked list traversal
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printListRecursive() {
        printListRecursive(head);
        System.out.println();
    }

    public void printListRecursive(Node head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        printListRecursive(head.next);
    }

    public void insertBegin(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void insertEnd(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = temp;
        }
    }

    public void deleteHead() {
        if (head != null) head = head.next;
    }

    public void deleteTail() {
        if (head != null) {
            if (head.next == null) head = null;
            else {
                Node curr = head;
                while (curr.next.next != null) curr = curr.next;
                curr.next = null;
            }
        }
    }

    public void insertPos(int pos, int data) {
        Node temp = new Node(data);
        if (pos == 0) {
            temp.next = head;
            head = temp;
        } else {
            Node curr = head;
            for (int i = 1; i <= pos - 1 && curr != null; i++) {
                curr = curr.next;
            }
            if (curr != null) {
                temp.next = curr.next;
                curr.next = temp;
            }
        }
    }

    public Node searchList(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) return curr;
            curr = curr.next;
        }
        return null;
    }

    public int searchListIndex(int key) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == key) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public Node searchListRecursive(int key) {
        return searchListRecursive(head, key);
    }

    public Node searchListRecursive(Node head, int key) {
        if (head == null) return null;
        if (head.data == key) return head;
        return searchListRecursive(head.next, key);
    }

    public int searchListRecursiveIndex(int key) {
        return searchListRecursiveIndex(head, key);
    }

    public int searchListRecursiveIndex(Node head, int key) {
        if (head == null) return -1;
        if (head.data == key) return 0;

        int index = searchListRecursiveIndex(head.next, key);
        if (index == -1) return -1;
        else return (index + 1);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        System.out.println("The list is:");
        list.printList();
        list.printListRecursive();

        System.out.println("After inserting 5 at the beginning:");
        list.insertBegin(5);
        list.printList();

        System.out.println("After inserting 45 at the end:");
        list.insertEnd(45);
        list.printList();

        System.out.println("After deleting head:");
        list.deleteHead();
        list.printList();

        System.out.println("After deleting tail:");
        list.deleteTail();
        list.printList();

        System.out.println("After inserting 15 at position 2:");
        list.insertPos(2, 15);
        list.printList();

        Node node = list.searchList(20);
        if (node != null) System.out.println("Found: " + node.data);
        else System.out.println("Not found");

        int index = list.searchListIndex(20);
        if (index != -1) System.out.println("Found at: " + index);
        else System.out.println("Not found");

        node = list.searchListRecursive(20);
        if (node != null) System.out.println("Found: " + node.data);
        else System.out.println("Not found");

        index = list.searchListRecursiveIndex(20);
        if (index != -1) System.out.println("Found at: " + index);
        else System.out.println("Not found");
    }
}
