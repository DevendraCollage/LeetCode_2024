/*
 * LC494
 */

import java.util.*;

public class LC494 {
    public static int findTargetSumWays(int[] nums, int target) {
        // Storing the total sum of nums element
        int s = 0;
        for (int i : nums) {
            s += i;
        }

        if (s < target || (s - target) % 2 != 0) {
            return 0;
        }

        int n = (s - target) / 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int v : nums) {
            for (int i = n; i >= v; i--) {
                dp[i] += dp[i - v];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Nums Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The Target : ");
        int target = sc.nextInt();
        System.out.println();

        int ans = findTargetSumWays(nums, target);

        System.out.println(ans);

        sc.close();
    }
}