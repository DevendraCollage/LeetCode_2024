/*
 * LC2275
 */

import java.util.*;

public class LC2275 {
    public static int largestCombination(int[] candidates) {
        int max = 0;
        for (int i = 0; i <= 24; i++) {
            int setBits = 0;
            for (int c : candidates) {
                setBits += (c >> i) & 1;
            }
            max = Math.max(setBits, max);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] arr = new int[size];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int answer = largestCombination(arr);

        System.out.println(answer);

        sc.close();
    }
}