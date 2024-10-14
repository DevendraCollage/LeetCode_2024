/*
 * LC2530
 */

import java.util.*;

public class LC2530 {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }
        long score = 0;
        while (k > 0) {
            int val = pq.poll();
            score += val;
            pq.offer((int) Math.ceil(val / 3.0));
            k--;
        }
        return score;
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

        System.out.print("Enter the K Value : ");
        int k = sc.nextInt();
        System.out.println();

        long ans = maxKelements(arr, k);

        System.out.println(ans);

        sc.close();
    }
}