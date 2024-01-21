package LinkedList;

class dNode {
    int data;
    dNode next;
    dNode prev;
    public dNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

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
    public static void main(String[] args) {
        dNode head = new dNode(10);
        dNode one = new dNode(20);
        dNode two = new dNode(30);

        head.next = one;
        one.prev = head;
        one.next = two;
        two.prev = one;

        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);
        System.out.println(head.next.next.prev.data);
    }
}
