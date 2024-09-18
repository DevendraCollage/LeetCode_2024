/*
 * LC179
 */

import java.util.*;

public class LC179 {
    public static String largestNumber(int[] nums) {
        String numStringArray[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStringArray[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStringArray, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < numStringArray.length; i++) {
            res.append(numStringArray[i]);
        }

        return res.charAt(0) == '0' ? "0" : res.toString();
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

        String answer = largestNumber(arr);

        System.out.println(answer);

        sc.close();
    }
}