/*
 * LC2601
 */

import java.util.Scanner;

public class LC2601 {
    public static boolean primeSubOperation(int[] nums) {
        int maxElem = getMaxElement(nums);

        boolean[] seive = new boolean[maxElem + 1];

        fill(seive, true);

        seive[1] = false;

        for (int i = 2; i <= Math.sqrt(maxElem + 1); i++) {
            if (seive[i]) {
                for (int j = i * i; j <= maxElem; j += i) {
                    seive[j] = false;
                }
            }
        }

        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            int diff = nums[i] - currValue;
            if (diff < 0) {
                return false;
            }
            if (seive[diff] == true || diff == 0) {
                i++;
                currValue++;
            } else {
                currValue++;
            }
        }

        return true;
    }

    // Function to find the max element
    private static int getMaxElement(int[] nums) {
        int max = -1;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    // Function to fill the array
    private static void fill(boolean[] arr, boolean value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
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

        boolean answer = primeSubOperation(arr);

        System.out.println(answer);

        sc.close();
    }
}