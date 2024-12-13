/*
 * LC2593
 */

import java.util.*;

public class LC2593 {
    public static long findScore(int[] nums) {
        // copy of the array
        // [element, index]
        int n = nums.length;
        int[][] copy = new int[n][2];
        for (int i = 0; i < n; i++) {
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }
        Arrays.sort(copy, (a, b) -> a[0] - b[0]);
        long res = 0;
        for (int i = 0; i < n; i++) {
            int elem = copy[i][0];
            int index = copy[i][1];
            if (nums[index] < 0) {
                continue;
            }
            res += nums[index];
            nums[index] = -nums[index];
            if (index - 1 >= 0 && nums[index - 1] > 0) {
                nums[index - 1] = -nums[index - 1];
            }
            if (index + 1 < n && nums[index + 1] > 0) {
                nums[index + 1] = -nums[index + 1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Length : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        long ans = findScore(nums);

        System.out.println(ans);

        sc.close();
    }
}