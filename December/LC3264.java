/*
 * LC3264
 */

import java.util.*;

public class LC3264 {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        // [element, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        // insert element in pq
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        // perform k time operations
        while (k > 0) {
            int arr[] = pq.poll();
            nums[arr[1]] = nums[arr[1]] * multiplier;
            pq.offer(new int[] { nums[arr[1]], arr[1] });
            k--;
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K : ");
        int k = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Multipliers : ");
        int multiplier = sc.nextInt();
        System.out.println();

        int[] ans = getFinalState(nums, k, multiplier);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d, ", ans[i]);
        }

        sc.close();
    }
}