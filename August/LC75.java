/*
 * LC75
 */

import java.util.Scanner;

public class LC75 {
    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index, start);
                index++;
                start++;
            } else if (nums[index] == 2) {
                swap(nums, index, end);
                end--;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Colors Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        sortColors(arr);

        System.out.println("After Sorting : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : [%d]\n", i, arr[i]);
        }

        sc.close();
    }
}