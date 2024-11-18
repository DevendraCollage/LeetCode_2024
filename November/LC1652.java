/*
 * LC1652
 */

import java.util.*;

public class LC1652 {
    // Helper function to calculate the prefix sum of the given array elements
    public static void calculateSum(int[] res, int k, int[] prefix) {
        // Length of Array
        int n = res.length;
        if (k > 0) {
            // Then we perform Right Sum
            for (int i = 0; i < n; ++i) {
                res[i] = prefix[i + k] - prefix[i];
            }
        } else {
            // Else We perform Left Sum
            k = -k; // Absolute value of k for left rotation
            for (int i = 0; i < n; ++i) {
                res[i] = prefix[i + n - 1] - prefix[i + n - k - 1];
            }
        }
    }

    public static int[] decrypt(int[] code, int k) {
        // Length of the Array
        int n = code.length;

        // Base Case
        if (k == 0) {
            // Fill Array with 0
            return new int[n];
        }

        // Build the prefix array with duplicated code values
        int[] prefix = new int[2 * n];
        prefix[0] = code[0];
        for (int i = 1; i < 2 * n; ++i) {
            prefix[i] = prefix[i - 1] + code[i % n];
        }

        int[] res = new int[n];
        calculateSum(res, k, prefix);

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K Elements : ");
        int k = sc.nextInt();
        System.out.println();

        int[] ans = decrypt(arr, k);

        System.out.println("This is The Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("[%d] : %d\n", i, ans[i]);
        }

        sc.close();
    }
}