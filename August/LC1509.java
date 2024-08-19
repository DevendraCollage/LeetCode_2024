/*
 * LC1509
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC1509 {
    public static int minDifference(int[] arr) {
        if (arr.length <= 4) {
            return 0;
        }
        Arrays.sort(arr);

        int n = arr.length;
        int res = Integer.MAX_VALUE;
        // Case-1
        res = Math.min(res, arr[n - 4] - arr[0]);
        // Case-2
        res = Math.min(res, arr[n - 3] - arr[1]);
        // Case-3
        res = Math.min(res, arr[n - 2] - arr[2]);
        // Case-4
        res = Math.min(res, arr[n - 1] - arr[3]);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size Array : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }

        int res = minDifference(arr);

        System.out.println(res);

        sc.close();
    }
}