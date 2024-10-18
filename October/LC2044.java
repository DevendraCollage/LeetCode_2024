/*
 * LC2044
 */

import java.util.*;

public class LC2044 {
    // p-np login (pick-no pick)
    public static int recur(int index, int nums[], int currOr, int targetOr, Integer dp[][]) {
        // base case
        if (index == nums.length) {
            return (currOr == targetOr) ? 1 : 0;
        }

        // Check if alread slved
        if (dp[index][currOr] != null) {
            return dp[index][currOr];
        }

        // pick
        int pickCount = recur(index + 1, nums, currOr | nums[index], targetOr, dp);
        // no pick
        int noPpickCount = recur(index + 1, nums, currOr, targetOr, dp);
        return dp[index][currOr] = pickCount + noPpickCount;
    }

    public static int countMaxOrSubsets(int[] nums) {
        // target or
        int targetOr = 0;
        for (int num : nums) {
            targetOr |= num;
        }
        Integer dp[][] = new Integer[nums.length][targetOr + 1];

        return recur(0, nums, 0, targetOr, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Length : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int ans = countMaxOrSubsets(arr);

        System.out.println(ans);

        sc.close();
    }
}