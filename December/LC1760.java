/*
 * LC1760
 */

import java.util.*;

public class LC1760 {
    public static int minimumSize(int[] nums, int maxOperations) {
        int r = 0;
        for (int num : nums) {
            r = Math.max(num, r);
        }
        int l = 1;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isPossible(nums, mid, maxOperations)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static boolean isPossible(int[] nums, int maxBallsAllowed, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            if (num > maxBallsAllowed) {
                int bags = (int) Math.ceil(num / (double) maxBallsAllowed);
                operations += bags - 1;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
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

        System.out.print("Enter The Max Operations : ");
        int maxOperations = sc.nextInt();
        System.out.println();

        int ans = minimumSize(arr, maxOperations);

        System.out.println(ans);

        sc.close();
    }
}