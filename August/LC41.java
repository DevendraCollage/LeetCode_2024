/*
 * LC41
 */

import java.util.Scanner;

public class LC41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] >= (n + 1)) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int elem = Math.abs(nums[i]);
            if (elem == n + 1) {
                continue;
            }
            int seat = elem - 1;
            if (nums[seat] > 0) {
                nums[seat] = -nums[seat];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int missing = firstMissingPositive(arr);

        System.out.println(missing);

        sc.close();
    }
}
