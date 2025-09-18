import java.util.Scanner;

public class TravellingSalesman {

    static int tsp(int[][] dist, int mask, int pos, int n, int[][] memo) {
        if (mask == (1 << n) - 1) {
            return dist[pos][0];
        }
        if (memo[pos][mask] != -1) {
            return memo[pos][mask];
        }

        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tsp(dist, mask | (1 << city), city, n, memo);
                ans = Math.min(ans, newAns);
            }
        }
        memo[pos][mask] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of cities:");
        int n = sc.nextInt();

        int[][] dist = new int[n][n];
        System.out.println("Enter distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        int[][] memo = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                memo[i][j] = -1;
            }
        }

        int result = tsp(dist, 1, 0, n, memo);
        System.out.println("Minimum cost of travelling all cities: " + result);
        sc.close();
    }
}
