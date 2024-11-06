/*
 * LC3011
 */

import java.util.Scanner;

public class LC3011 {
    // This is the SSC (Shortest Subsequence Count) approach
    public static boolean canSortArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }

        int prevSegmentMax = Integer.MIN_VALUE;
        int currSegmentMax = nums[0];
        int currSegmentMin = nums[0];
        int setBitCount = Integer.bitCount(nums[0]);
        int i = 1;

        while (i < n) {
            // Extract current segment
            while (i < n && Integer.bitCount(nums[i]) == setBitCount) {
                currSegmentMax = Math.max(currSegmentMax, nums[i]);
                currSegmentMin = Math.min(currSegmentMin, nums[i]);
                i++;
            }
            if (prevSegmentMax > currSegmentMin) {
                return false;
            } else if (i < n) {
                prevSegmentMax = currSegmentMax;
                currSegmentMax = nums[i];
                currSegmentMin = nums[i];
                setBitCount = Integer.bitCount(nums[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] arr = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        boolean answer = canSortArray(arr);

        System.out.println(answer);

        sc.close();
    }
}