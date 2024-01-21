package LinkedList;

public class Node {
    int data;
    Node next; // self referential structure
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
