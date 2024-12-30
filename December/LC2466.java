/*
 * LC2466
 */

import java.util.*;

public class LC2466 {
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int maxLen = high + Math.max(zero, one);
        int[] dp = new int[maxLen + 1];
        Arrays.fill(dp, -1);
        return recur(low, high, zero, one, 0, dp);
    }

    public static int recur(int low, int high, int zero, int one, int len, int[] dp) {
        // Base case
        if (len > high) {
            dp[len] = 0;
            return 0;
        }
        if (dp[len] != -1) {
            return dp[len];
        }

        int zeroLen = len + zero;
        int oneLen = len + one;
        int zeroCount = (zeroLen >= low && zeroLen <= high) ? 1 : 0;
        int oneCount = (oneLen >= low && oneLen <= high) ? 1 : 0;
        int res = zeroCount + recur(low, high, zero, one, zeroLen, dp) + oneCount
                + recur(low, high, zero, one, oneLen, dp);
        dp[len] = res % (1000000007);
        return dp[len];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Low : ");
        int low = sc.nextInt();
        System.out.println();

        System.out.print("Enter High : ");
        int high = sc.nextInt();
        System.out.println();

        System.out.print("Enter Zero : ");
        int zero = sc.nextInt();
        System.out.println();

        System.out.print("Enter One : ");
        int one = sc.nextInt();
        System.out.println();

        int ans = countGoodStrings(low, high, zero, one);

        System.out.println(ans);

        sc.close();
    }
}