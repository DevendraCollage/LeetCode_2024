/*
 * LC3097
 */

import java.util.Scanner;

public class LC3097 {
    public static int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32]; // To count each bit position
        int res = Integer.MAX_VALUE;
        int left = 0;

        // Sliding window approach
        for (int i = 0; i < nums.length; i++) {
            addBit(nums[i], bits);

            // Shrink the window from the left while the condition is satisfied
            while (currentBitSum(bits) >= k && left <= i) {
                res = Math.min(res, i - left + 1);
                subtractBits(nums[left], bits);
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // Function too add bits or a number to the bit count array
    private static void addBit(int num, int[] bits) {
        int i = 0;
        while (num > 0) {
            bits[i] += num & 1;
            num >>= 1;
            i++;
        }
    }

    // Function to subtract bits of a number from the bit count array
    private static void subtractBits(int num, int[] bits) {
        int i = 0;
        while (num > 0) {
            bits[i] -= num & 1;
            num >>= 1;
            i++;
        }
    }

    // Function to reconstruct the current bitwise OR value
    private static int currentBitSum(int[] bits) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > 0) {
                result |= (1 << i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K Elements : ");
        int k = sc.nextInt();
        System.out.println();

        int answer = minimumSubarrayLength(arr, k);

        System.out.println(answer);

        sc.close();
    }
}