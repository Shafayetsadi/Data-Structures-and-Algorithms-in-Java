package LinkedList;



/*
 * Advantages over singly linked list
 * - can be traversed in both directions
 * - A given node can be deleted without traversing the list with given node reference/pointer
 * - We can quickly insert/delete a node before a given node reference/pointer
 * - We can quickly insert/delete a node after a given node reference/pointer
 *
 * Disadvantages over singly linked list
 * - It requires more space to store prev pointer
 * - Insertion and deletion operations are a bit more complex
 * - Not easy to implement
 * */

public class DoublyList {
    private dNode head;

    public void printList() {
        dNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void insertBegin(int data) {
        dNode temp = new dNode(data);
        temp.next = head;
        if (head != null) head.prev = temp;
        head = temp;
    }

    public void insertEnd(int data) {
        dNode temp = new dNode(data);
        if (head == null) {
            head = temp;
        } else {
            dNode curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = temp;
            temp.prev = curr;
        }
    }

    public void deleteHead() {
        if (head != null && head.next != null) {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteTail() {
        if (head != null && head.next != null) {
            dNode curr = head;
            while (curr.next.next != null) curr = curr.next;
            curr.next = null;
        }
    }

    public void reverseList() {
        if (head != null && head.next != null) {
            dNode curr = head;
            dNode prev = null;
            while (curr != null) {
                prev = curr.prev;
                curr.prev = curr.next;
                curr.next = prev;
                curr = curr.prev;
            }
            head = prev.prev;
        }
    }

    public static void main(String[] args) {
        DoublyList list = new DoublyList();
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);

        list.printList();

        list.insertBegin(5);
        list.printList();

        list.insertEnd(45);
        list.printList();

        list.reverseList();
        list.printList();

        list.deleteHead();
        list.printList();

        list.deleteTail();
        list.printList();

        list.reverseList();
        list.printList();
    }
}
