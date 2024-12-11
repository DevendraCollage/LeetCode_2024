/*
 * LC2779
 */

import java.util.*;

public class LC2779 {
    public static int maximumBeauty(int[] nums, int k) {
        // Base Case
        if (nums.length == 1) {
            return 1;
        }

        // Create count array
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];

        // Insert range in count array
        for (int num : nums) {
            count[Math.max(num - k, 0)]++;
            count[Math.min(num + k + 1, max)]--;
        }

        // Find max of prefix sum
        int curSum = 0, maxSum = 0;
        for (int c : count) {
            curSum += c;
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Length : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Number Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K Elements : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = maximumBeauty(nums, k);

        System.out.println(ans);

        sc.close();
    }
}