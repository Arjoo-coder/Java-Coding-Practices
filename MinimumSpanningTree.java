import java.util.*;

public class MinimumSpanningTree {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private static void union(int[] parent, int[] rank, int root1, int root2) {
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }

    public static void kruskalMST(int vertices, List<Edge> edges) {
        Collections.sort(edges);

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            int root1 = find(parent, edge.src);
            int root2 = find(parent, edge.dest);

            if (root1 != root2) {
                mst.add(edge);
                totalWeight += edge.weight;
                union(parent, rank, root1, root2);
            }

            if (mst.size() == vertices - 1) {
                break;
            }
        }

        System.out.println("Minimum Spanning Tree using Kruskal's greedy algorithm:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
        System.out.println("Total weight: " + totalWeight);
    }

    public static void main(String[] args) {
        int vertices = 5;

        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 2),
            new Edge(0, 3, 6),
            new Edge(1, 2, 3),
            new Edge(1, 3, 8),
            new Edge(1, 4, 5),
            new Edge(2, 4, 7),
            new Edge(3, 4, 9)
        );

        kruskalMST(vertices, edges);
    }
}
