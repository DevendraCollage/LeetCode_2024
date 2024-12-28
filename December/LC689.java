/*
 * LC689
 */

import java.util.*;

public class LC689 {
    private static int[] prefixSum;
    private static int[][] mem;

    // Helper function to find the max sum
    private static int findMaxSum(int[] nums, int pos, int count, int k) {
        // Base Cases
        if (count == 3) {
            return 0;
        }
        if (pos > nums.length - k) {
            return 0;
        }
        if (mem[pos][count] != -1) {
            return mem[pos][count];
        }

        // Don't start sub array here
        int dontStart = findMaxSum(nums, pos + 1, count, k);

        // Start sub array here
        int startHere = findMaxSum(nums, pos + k, count + 1, k) + prefixSum[pos + k] - prefixSum[pos];

        return mem[pos][count] = Math.max(dontStart, startHere);
    }

    // Helper function to find path of the Max Sum
    private static void findMaxSumPath(int[] nums, int pos, int count, int k, int[] path, int pathIndex) {
        // Base case
        if (count == 3) {
            return;
        }
        if (pos > nums.length - k) {
            return;
        }

        // Don't start sub array here
        int dontStart = findMaxSum(nums, pos + 1, count, k);

        // Start sub array here
        int startHere = findMaxSum(nums, pos + k, count + 1, k) + prefixSum[pos + k] - prefixSum[pos];

        // Chose optimal path
        if (startHere >= dontStart) {
            path[pathIndex] = pos;
            findMaxSumPath(nums, pos + k, count + 1, k, path, pathIndex + 1); // Include pos
        } else {
            findMaxSumPath(nums, pos + 1, count, k, path, pathIndex); // Don't include pos
        }
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        mem = new int[n][3];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        findMaxSum(nums, 0, 0, k);

        int[] path = new int[3];
        findMaxSumPath(nums, 0, 0, k, path, 0);

        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Element : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K-Value : ");
        int k = sc.nextInt();
        System.out.println();

        int[] ans = maxSumOfThreeSubarrays(nums, k);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}