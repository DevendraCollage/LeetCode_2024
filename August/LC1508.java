/*
 * LC1508
 */

import java.util.*;

public class LC1508 {
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int) 1e9 + 7;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        int sum = 0;
        for (int index = 0; index < right; index++) {
            int cur[] = pq.poll();
            if (index >= left - 1) {
                sum = (sum + cur[0]) % mod;
            }
            if (cur[1] + 1 < n) {
                cur[1]++;
                cur[0] = cur[0] + nums[cur[1]];
                pq.offer(cur);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Array : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.println("Enter the Left Starting : ");
        int left = sc.nextInt();
        System.out.println("Enter the Right Ending : ");
        int right = sc.nextInt();

        int sum = rangeSum(arr, size, left, right);
        System.out.println(sum);

        sc.close();
    }
}