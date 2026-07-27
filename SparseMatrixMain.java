// 1. Node class to represent each non-zero element
class Node {
    int row;
    int col;
    int value;
    Node next;

    public Node(int r, int c, int v) {
        this.row = r;
        this.col = c;
        this.value = v;
        this.next = null;
    }
}

// 2. Sparse Matrix class
class SparseMatrix {
    private Node head = null;
    private Node tail = null;

    // Method to insert a non-zero element into the linked list
    public void insert(int r, int c, int v) {
        Node newNode = new Node(r, c, v);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to display the linked list representation
    public void printList() {
        System.out.println("\nLinked List Representation (Row, Col, Value):");
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.row + ", " + current.col + ", " + current.value + "] -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Method to display the reconstructed matrix
    public void printMatrix(int totalRows, int totalCols) {
        System.out.println("\nReconstructed Full Matrix:");
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                // Search if this (i, j) exists in our linked list
                int val = getValue(i, j);
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Helper method to look up a value at a specific row and col
    private int getValue(int r, int c) {
        Node current = head;
        while (current != null) {
            if (current.row == r && current.col == c) {
                return current.value;
            }
            current = current.next;
        }
        return 0; // Return 0 if the coordinate is not in the list
    }
}

// 3. Main testing class
public class SparseMatrixMain {
    public static void main(String[] args) {
        // Example 4x5 Sparse Matrix with mostly zeros
        int[][] matrix = {
            {0, 0, 3, 0, 0},
            {0, 0, 0, 0, 7},
            {0, 5, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        SparseMatrix sm = new SparseMatrix();

        // Step 1: Scan matrix and insert only non-zero elements
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    sm.insert(i, j, matrix[i][j]);
                }
            }
        }

        // Step 2: Print outputs
        sm.printList();
        sm.printMatrix(matrix.length, matrix[0].length);
    }
}
