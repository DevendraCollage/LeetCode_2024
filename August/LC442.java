/*
 * LC442
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC442 {
    public static List<Integer> findDuplicates(int[] nums) {
        // ! 1 Brute Force
        // List<Integer> l1 = new ArrayList<>();
        // int n = nums.length;

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < i; j++) {
        // if (nums[i] == nums[j]) {
        // l1.add(nums[i]);
        // }
        // }
        // }

        // return l1;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int elem = Math.abs(nums[i]);
            int seat = elem - 1;
            if (nums[seat] < 0) {
                res.add(elem);
            } else {
                nums[seat] = -nums[seat];
            }
        }

        return res;
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

        List<Integer> l1 = findDuplicates(arr);

        System.out.println(l1.toString());

        sc.close();
    }
}
