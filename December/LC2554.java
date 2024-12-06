/*
 * LC2554
 */

import java.util.*;

public class LC2554 {
    public static int maxCount(int[] banned, int n, int maxSum) {
        // HashSet<Integer> set = new HashSet<>();
        boolean[] set = new boolean[10001];
        for (int ba : banned) {
            set[ba] = true;
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set[i] == true) {
                continue;
            }
            sum += i;
            if (sum > maxSum) {
                break;
            }
            count++;
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

        System.out.print("Enter The N : ");
        int size = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Max Sum : ");
        int maxSum = sc.nextInt();
        System.out.println();

        int ans = maxCount(arr, size, maxSum);

        System.out.println(ans);

        sc.close();
    }
}