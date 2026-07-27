class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoubleCircularLinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    void insertAfter(int prevNode, int data){
        Node newNode = new Node(data);
        Node temp = head;
        while(temp!=null && temp.data != prevNode){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println(prevNode+" Not in list");
            return;//
        }
        
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;

        if(newNode.next != null){
            newNode.next.prev = newNode;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleCircularLinkedList list = new DoubleCircularLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.insertAfter(20, 25);

        list.display();
    }
}