public class Knapsack01{

    public static void main(String[] args) {

        int[] weights = {1, 3, 4, 6};
        int[] values = {2, 5, 7, 8};
        int capacity = 7;

        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {

                if (weights[i - 1] <= w) {
                    int include = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                    int exclude = dp[i - 1][w];
                    dp[i][w] = Math.max(include, exclude);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Max Value = " + dp[n][capacity]);
    }
}
