public class Warshall {
    public static void main(String[] args) {

        int V = 4;
        int[][] graph = {

            {1, 0, 1, 0},
            {0, 1, 1, 1},
            {0, 0, 1, 0},
            {1, 0, 0, 1}
        };

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
        System.out.println("Transitive Closure:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");     
            }
            System.out.println();
        }
    }
}