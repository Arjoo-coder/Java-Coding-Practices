import java.util.*;

public class kk {

    static int find(int parent[], int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    static void union(int parent[], int x, int y) {
        parent[x] = y;
    }

    public static void main(String[] args) {

        int vertices = 5;   // ✅ Corrected (0 to 4 total 5 vertices)

        int edges[][] = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 2, 3},
                {1, 3, 8},
                {1, 4, 5},
                {2, 4, 7},
                {3, 4, 9}
        };

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int parent[] = new int[vertices];

        for (int i = 0; i < vertices; i++)
            parent[i] = i;

        System.out.println("Minimum Spanning Tree:");

        int count = 0;
        int totalCost = 0;

        for (int i = 0; i < edges.length && count < vertices - 1; i++) {

            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];

            int x = find(parent, src);
            int y = find(parent, dest);

            if (x != y) {
                System.out.println(src + " - " + dest + " : " + weight);
                totalCost += weight;
                union(parent, x, y);
                count++;
            }
        }
        System.out.println("Total Cost: " + totalCost);
    }
}