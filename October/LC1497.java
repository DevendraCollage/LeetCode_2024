/*
 * LC1497
 */

import java.util.*;

public class LC1497 {
    public static boolean canArrange(int[] arr, int k) {
        int count[] = new int[k];
        for (int i : arr) {
            count[((i % k) + k) % k]++;
        }
        if (count[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (count[i] != count[k - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The k Value : ");
        int k = sc.nextInt();
        System.out.println();

        boolean ans = canArrange(arr, k);

        System.out.println(ans);

        sc.close();
    }
}