/*
 * LC2419
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */

import java.util.*;

public class LC2419 {
    public static int longestSubarray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int count = 0;
        int answer = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                count++;
            } else {
                count = 0;
            }
            answer = Math.max(answer, count);
        }

        return answer;
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

        int answer = longestSubarray(arr);

        System.out.println(answer);

        sc.close();
    }
}