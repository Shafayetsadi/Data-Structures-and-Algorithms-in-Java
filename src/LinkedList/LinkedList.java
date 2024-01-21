package LinkedList;

public class LinkedList {
    // Linked list traversal
    public static void printList(Node head){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void printListRecursive(Node head){
        if(head == null) return;
        System.out.print(head.data + " ");
        printListRecursive(head.next);
    }

    public static Node insertBegin(Node head, int data){
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    public static Node insertEnd(Node head, int data){
        Node temp = new Node(data);
        if(head == null) return temp;
        Node curr = head.next;
        while (curr.next != null) curr = curr.next;
        curr.next = temp;
        return head;
    }

    public static Node deleteHead(Node head){
        if(head == null) return null;
        else return head.next;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;
        Node curr = head;
        while (curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static Node insertPos(Node head, int pos, int data){
        Node temp = new Node(data);
        if(pos == 1){
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for(int i = 1; i <= pos - 2 && curr != null; i++){
            curr = curr.next;
        }
        if(curr == null) return head;
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static Node searchList(Node head, int key){
        Node curr = head;
        while (curr != null){
            if(curr.data == key) return curr;
            curr = curr.next;
        }
        return null;
    }

    public static Node searchListRecursive(Node head, int key){
        if(head == null) return null;
        if(head.data == key) return head;
        return searchListRecursive(head.next, key);
    }
    public static int searchListRecursiveIndex(Node head, int key){
        if(head == null) return -1;
        if(head.data == key) return 1;

        int index = searchListRecursiveIndex(head.next, key);
        if(index == -1) return -1;
        else return (index + 1);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);

        head.next = a;
        a.next = b;

        printList(head);
        System.out.println();

        printListRecursive(head);
        System.out.println();

        head = insertBegin(head, 5);
        printList(head);
        System.out.println();

        head = insertEnd(head, 45);
        printList(head);
        System.out.println();

        head = deleteHead(head);
        printList(head);
        System.out.println();

        head = deleteTail(head);
        printList(head);
        System.out.println();


    }
}
