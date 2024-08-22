/*
 * LC945
 */

import java.util.Scanner;

public class LC945 {
    public static int findMax(int nums[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static int minIncrementForUnique(int[] nums) {
        int maxEl = findMax(nums);
        int n = nums.length;
        int countArr[] = new int[maxEl + n];
        for (int num : nums) {
            countArr[num]++;
        }
        int moves = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 1) {
                int extra = countArr[i] - 1;
                countArr[i + 1] += extra;
                moves += extra;
                countArr[i] = 1;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements :");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int moves = minIncrementForUnique(arr);

        System.out.println(moves);
        sc.close();
    }
}