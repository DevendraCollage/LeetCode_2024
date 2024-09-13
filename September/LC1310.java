/*
 *C1310
 */

import java.util.*;

public class LC1310 {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        int xor = prefix[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
            prefix[i] = xor;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = prefix[right];
            if (left > 0) {
                ans[i] ^= prefix[left - 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter the Size of Array : ");
        int size2 = sc.nextInt();

        int arr2[][] = new int[size2][size2];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr2[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans[] = xorQueries(arr, arr2);

        System.out.println("Answer is : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        sc.close();
    }
}