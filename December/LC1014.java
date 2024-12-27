/*
 * LC1014
 */

import java.util.Scanner;

public class LC1014 {
    public static int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int n = values.length;
        // formula v[i] + i
        int leftMax = values[0] + 0;
        for (int i = 1; i < n; i++) {
            // formula v[i] - i
            int rightVal = values[i] - i;
            res = Math.max(res, leftMax + rightVal);
            leftMax = Math.max(leftMax, values[i] + i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Values Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] values = new int[n];

        System.out.println("Enter The Values Array Elements : ");
        for (int i = 0; i < values.length; i++) {
            System.out.printf("%d : ", i);
            values[i] = sc.nextInt();
        }
        System.out.println();

        int ans = maxScoreSightseeingPair(values);

        System.out.println(ans);

        sc.close();
    }
}