/*
 * LC1829
 */

import java.util.Scanner;

public class LC1829 {

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ nums[i];
        }

        int[] ans = new int[n];
        int mask = (1 << maximumBit) - 1;

        for (int i = n - 1; i >= 0; --i) {
            ans[n - 1 - i] = prefixXor[i] ^ mask;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] arr = new int[size];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The Maximum Bit Number : ");
        int maxBit = sc.nextInt();
        System.out.println();

        int[] answer = getMaximumXor(arr, maxBit);

        System.out.println("This Is The Answer : ");
        for (int i : answer) {
            System.out.println(i);
        }

        sc.close();
    }
}