/*
 * LC2220
 */

import java.util.*;

public class LC2220 {
    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while (xor > 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Start : ");
        int start = sc.nextInt();
        System.out.print("Enter the Goal : ");
        int goal = sc.nextInt();
        System.out.println();

        int result = minBitFlips(start, goal);

        System.out.println(result);

        sc.close();
    }
}