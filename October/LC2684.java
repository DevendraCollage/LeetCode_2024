/*
 * LC2684
 */

import java.util.*;

public class LC2684 {
    public static int maxMoves(int[][] grid) {
        int ans = 0;
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            ans = Math.max(ans, solve(grid, i, 0, dp));
        }
        return ans;
    }

    public static int solve(int grid[][], int row, int col, int dp[][]) {
        // Base Case
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;

        if (row - 1 >= 0 && col + 1 < grid[0].length && grid[row][col] < grid[row - 1][col + 1]) {
            pos1 = 1 + solve(grid, row - 1, col + 1, dp);
        }
        if (col + 1 < grid[0].length && grid[row][col] < grid[row][col + 1]) {
            pos2 = 1 + solve(grid, row, col + 1, dp);
        }
        if (row + 1 < grid.length && col + 1 < grid[0].length && grid[row][col] < grid[row + 1][col + 1]) {
            pos3 = 1 + solve(grid, row + 1, col + 1, dp);
        }
        return dp[row][col] = Math.max(pos1, Math.max(pos2, pos3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Matrix Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] arr = new int[n][n];

        System.out.println("Enter The Matrix Elements : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = maxMoves(arr);

        System.out.println(ans);

        sc.close();
    }
}