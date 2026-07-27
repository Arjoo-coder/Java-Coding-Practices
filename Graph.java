class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Graph {
    int totalVertices;
    Node[] adj;

    public Graph(int totalVertices) {
        this.totalVertices = totalVertices;
        adj = new Node[totalVertices];
        for (int i = 0; i < totalVertices; i++) {
            adj[i] = null;
        }
    }

    public void addEdge(int src, int dest) {
        Node temp = new Node(dest);
        temp.next = adj[src];
        adj[src] = temp;

        temp = new Node(src);
        temp.next = adj[dest];
        adj[dest] = temp;
    }

    public void printGraph() {
        for (int i = 0; i < totalVertices; i++) {
            System.out.print("Vertex " + i + ":");
            Node temp = adj[i];
            while (temp != null) {
                System.out.print(" -> " + temp.data);
                temp = temp.next;
            }
            System.out.println(" -> null");
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
