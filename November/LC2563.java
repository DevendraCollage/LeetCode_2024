/*
 * LC2563
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC2563 {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countLess(nums, upper) - countLess(nums, lower - 1);
    }

    // Helper function to find the count of the lower and upper of the given array
    private static long countLess(int[] nums, int sum) {
        long result = 0;
        for (int i = 0, j = nums.length - 1; i < j; ++i) {
            while (i < j && nums[i] + nums[j] > sum) {
                --j;
            }
            result += j - i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Length : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements :");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter Lower Number : ");
        int lower = sc.nextInt();
        System.out.println();

        System.out.print("Enter Upper Number : ");
        int upper = sc.nextInt();
        System.out.println();

        long answer = countFairPairs(arr, lower, upper);

        System.out.println(answer);

        sc.close();
    }
}