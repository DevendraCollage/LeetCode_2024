/*
 * LC1574
 */

import java.util.Scanner;

public class LC1574 {
    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l + 1 < n && arr[l] <= arr[l + 1]) {
            ++l;
        }

        if (l == n - 1) {
            return 0;
        }

        while (r > l && arr[r - 1] <= arr[r]) {
            --r;
        }

        int result = Math.min(n - l - 1, r);

        for (int i = 0, j = r; i <= l && j < n;) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int answer = findLengthOfShortestSubarray(arr);

        System.out.println(answer);

        sc.close();
    }
}