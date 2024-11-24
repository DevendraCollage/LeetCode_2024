/*
 * LC1975
 */

import java.util.*;

public class LC1975 {
    public static long maxMatrixSum(int[][] matrix) {
        int minAbsValue = Integer.MAX_VALUE; // Minimum absolute value
        int negatives = 0; // Count of negative numbers
        long totalSum = 0; // Sum of absolute values of all elements

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value); // Add absolute value to the sum
                if (value < 0) {
                    negatives++; // Count negatives
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if ((negatives & 1) == 0) {
            return totalSum;
        }

        // If negatives are odd, subtract twice the smallest absolute value
        return totalSum - 2 * minAbsValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Row : ");
        int row = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] matrix = new int[row][col];

        System.out.println("Enter The Matrix Elements : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        long ans = maxMatrixSum(matrix);

        System.out.println(ans);

        sc.close();
    }
}