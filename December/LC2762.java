/*
 * LC2762
 */

import java.util.Scanner;

public class LC2762 {
    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0;
        int rangeMin = nums[0];
        int rangeMax = nums[0];

        long count = 0;
        long winSize;
        int right;

        for (right = 0; right < n; right++) {
            rangeMin = Math.min(rangeMin, nums[right]);
            rangeMax = Math.max(rangeMax, nums[right]);

            if (rangeMax - rangeMin > 2) {
                winSize = right - left;
                count += (winSize * (winSize + 1)) / 2;

                left = right;
                // Expand current window to as left as possible
                rangeMin = nums[right];
                rangeMax = nums[right];
                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    rangeMin = Math.min(rangeMin, nums[left]);
                    rangeMax = Math.max(rangeMax, nums[left]);
                }
                // Subtract overcounted subarrays
                if (left < right) {
                    winSize = right - left;
                    count -= (winSize * (winSize + 1)) / 2;
                }
            }
        }
        // Add subarrays from the last window
        winSize = right - left;
        count += (winSize * (winSize + 1)) / 2;

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Length : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        long ans = continuousSubarrays(nums);

        System.out.println(ans);

        sc.close();
    }
}