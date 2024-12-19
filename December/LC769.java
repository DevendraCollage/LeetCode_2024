/*
 * LC769
 */

import java.util.*;

public class LC769 {
    public static int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max < i + 1) {
                count++;
            }
        }
        return count;
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

        int ans = maxChunksToSorted(arr);

        System.out.println(ans);

        sc.close();
    }
}