/*
 * LC3243
 */

import java.util.*;

public class LC3243 {
    // Adjacency Lists
    static List<List<Integer>> adj;

    static int[] dp;
    static int na;

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        na = n;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i <= n - 2; i++) {
            adj.get(i).add(i + 1);
        }

        int[] ans = new int[queries.length];
        int i = 0;
        dp = new int[n];
        for (int[] query : queries) {
            adj.get(query[0]).add(query[1]);
            Arrays.fill(dp, -1);
            ans[i++] = sol(0);
        }

        return ans;
    }

    // Helper function
    private static int sol(int u) {
        if (u == na - 1) {
            return 0;
        }

        if (dp[u] != -1) {
            return dp[u];
        }

        int min = na + 1;
        for (Integer nei : adj.get(u)) {
            min = Math.min(min, 1 + sol(nei));
        }

        return dp[u] = min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Queries Array SIze : ");
        int size = sc.nextInt();
        System.out.println();

        int[][] queries = new int[size][size];

        System.out.println("Enter The Queries Array Elements : ");
        for (int i = 0; i < queries.length; i++) {
            for (int j = i; j < queries.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                queries[i][j] = sc.nextInt();
            }
        }

        int[] ans = shortestDistanceAfterQueries(n, queries);

        System.out.println("Given is the Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}