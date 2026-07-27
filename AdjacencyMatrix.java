public class AdjacencyMatrix {
    public static void main(String[] args) {
        int n = 11; 

        int [][] adjMatrix = new int[n][n];

        char[][] edges = {
            {'A','F'}, 
            {'A','C'},
            {'A','B'},
            {'C','F'}, 
            {'D','C'},  
            {'E','D'},
            {'E','C'},
            {'E','J'},
            {'F','D'},
            {'G','C'},
            {'G','E'},
            {'J','D'},
            {'J','K'},
            {'K','E'},
            {'K','G'}
        };

        for (char[] edge : edges) {
            int u = edge[0]-'A';
            int v = edge[1]-'A';
            adjMatrix[u][v] = 1; 
            adjMatrix[v][u] = 1; 
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}