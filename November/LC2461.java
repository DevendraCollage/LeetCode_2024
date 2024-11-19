/*
 * LC2461
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LC2461 {
    public static long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long cs = 0;
        int begin = 0, end = 0;

        Map<Integer, Integer> lastseen = new HashMap<>();

        while (end < nums.length) {
            int curr = nums[end];
            int j = lastseen.getOrDefault(curr, -1);

            // Discard the sliding window element from begin to end
            while (j >= begin || (end - begin + 1) > k) {
                cs -= nums[begin++];
            }
            cs += nums[end];
            lastseen.put(curr, end);

            // Capture or not
            if (end - begin + 1 == k) {
                ans = Math.max(ans, cs);
            }
            end++;
        }

        return ans;
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

        System.out.print("Enter The k Elements : ");
        int k = sc.nextInt();
        System.out.println();

        long ans = maximumSubarraySum(arr, k);
        System.out.println(ans);

        sc.close();
    }
}