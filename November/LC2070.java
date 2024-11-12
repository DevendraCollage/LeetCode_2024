/*
 * LC2070
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC2070 {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        // This store the answer
        int[] answer = new int[queries.length];
        int[] maxBeautySoFar = new int[items.length + 1];

        // Sort the Array
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // This will find the maxBeauty of the given price value
        for (int i = 0; i < items.length; i++) {
            maxBeautySoFar[i + 1] = Math.max(maxBeautySoFar[i], items[i][1]);
        }

        for (int i = 0; i < queries.length; i++) {
            final int index = firstGreater(items, queries[i]);
            answer[i] = maxBeautySoFar[index];
        }

        return answer;
    }

    // This is out helper function to find the max first greater element
    private static int firstGreater(int[][] items, int q) {
        int l = 0;
        int r = items.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if (items[m][0] > q) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] arr = new int[n][n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.print("Enter The Queries Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] arr2 = new int[size];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("[%d] : ", i);
            arr2[i] = sc.nextInt();
        }
        System.out.println();

        int[] answer = maximumBeauty(arr, arr2);

        System.out.println("Answer : ");
        for (int i = 0; i < answer.length; i++) {
            System.out.printf("%d ", answer[i]);
        }

        sc.close();
    }
}