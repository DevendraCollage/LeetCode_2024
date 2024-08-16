/*
 * LC912
 */

import java.util.Scanner;

public class LC912 {
    public static void merge(int nums[], int s, int m, int e) {
        int n1 = m - s + 1;
        int n2 = e - m;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = nums[s + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = nums[m + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = s;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                nums[k] = arr1[i];
                i++;
            } else {
                nums[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            nums[k] = arr1[i];
            i++;
            k++;
        }
        while (i < n2) {
            nums[k] = arr2[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int nums[], int s, int e) {
        if (s < e) {
            int m = s + (e - s) / 2;
            mergeSort(nums, s, m);
            mergeSort(nums, m + 1, e);
            merge(nums, s, m, e);
        }
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size Of Array : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();
        sc.close();

        int[] n = sortArray(arr);

        System.out.println("Sorted Array : ");
        for (int i = 0; i < n.length; i++) {
            System.out.printf("[%d] : %d\n", i, n[i]);
        }
    }
}