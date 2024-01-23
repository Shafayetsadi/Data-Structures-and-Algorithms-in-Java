package LinkedList;

public class Node {
    public int data;
    public Node next; // self referential structure
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
