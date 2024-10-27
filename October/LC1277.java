/*
 * LC1277
 */

import java.util.*;

public class LC1277 {
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int ans = 0;

        // For the firs row and column
        for (int i = 1; i < m; i++) {
            dp[0][i] = matrix[0][i];
            ans += dp[0][i];
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];
                    int topLeft = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(Math.min(left, top), topLeft);
                }
                ans += dp[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Row Size : ");
        int row = sc.nextInt();
        System.out.println();

        System.out.print("Enter the Column Size : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] mat = new int[row][col];

        System.out.println("Enter the Matrix elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = countSquares(mat);

        System.out.println(ans);

        sc.close();
    }
}