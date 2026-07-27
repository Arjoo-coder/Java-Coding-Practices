
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleCircularLinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        
        temp.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    void display() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }
        
        Node temp = head;
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;

        }while (temp != head);
        System.out.println(temp.data );
    }
    public static void main(String[] args) {
        SingleCircularLinkedList list = new SingleCircularLinkedList(); 
        list.insert( 10);
        list.insert(20);
        list.insert(30);
        
        list.display();
    }
}
