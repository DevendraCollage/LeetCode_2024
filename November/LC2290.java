/*
 * LC2290
 */

import java.util.*;

public class LC2290 {
    // 2-D Direction Array
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int n, m;
    static int[][] griD;
    static int[][] dp;

    public static int minimumObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        griD = grid;

        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE); // Initialize dp array with a large value
        }

        // Dijkstra Algorithm
        dp[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, dp[0][0] });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int obs = curr[2], row = curr[0], col = curr[1];

            if (row == m - 1 && col == n - 1) {
                return obs;
            }

            for (int[] d : dir) {
                int r = row + d[0], c = col + d[1];

                if (!isValid(grid, r, c)) {
                    continue;
                }

                int newobs = obs + grid[r][c];
                if (newobs < dp[r][c]) {
                    dp[r][c] = newobs;
                    pq.add(new int[] { r, c, newobs });
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // Helper function to check the given is valid or nots
    private static boolean isValid(int[][] grid, int row, int col) {
        return (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Grid Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] grid = new int[n][n];

        System.out.println("Enter The Grid Elements : ");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = minimumObstacles(grid);

        System.out.println(ans);

        sc.close();
    }
}