/*
 * LC2022
 */

import java.util.Scanner;

public class LC2022 {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }
        int res[][] = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index];
                index++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter the Row Size : ");
        int row = sc.nextInt();
        System.out.println();

        System.out.print("Enter the Column Size : ");
        int column = sc.nextInt();
        System.out.println();

        int newArr[][] = construct2DArray(arr, row, column);

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr.length; j++) {
                System.out.printf("[%d][%d] : %d\t", i, j, newArr[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}