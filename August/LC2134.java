
/**
 * LC2134
 */

import java.util.*;

public class LC2134 {
    public static int minSwaps(int nums[]) {
        int windowSize = 0;
        for (int item : nums) {
            if (item == 1) {
                windowSize++;
            }
        }
        int curZero = 0;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0) {
                curZero++;
            }
        }
        int minZeros = curZero;
        int start = 0;
        int end = windowSize - 1;
        int n = nums.length;
        while (start < n) {
            if (nums[start] == 0) {
                curZero--;
            }
            start++;
            end++;
            if (nums[end % n] == 0) {
                curZero++;
            }
            minZeros = Math.min(minZeros, curZero);
        }
        return minZeros;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the Array : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }

        int min = minSwaps(arr);
        System.out.println(min);

        sc.close();
    }
}