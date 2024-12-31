/*
 * LC983
 */

import java.util.*;

public class LC983 {
    public static int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        int lastDay = days[days.length - 1];
        // Using DP for overlapping subproblem
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, 0);
        // Adding to the set to track the values which should be added or not added
        for (int day : days) {
            set.add(day);
        }

        for (int currDay = 1; currDay <= lastDay; currDay++) {
            if (!set.contains(currDay)) {
                // If not a travel day, carry forward the previous day's cost
                dp[currDay] = dp[currDay - 1];
            } else {
                // Calculate the minimum cost for the current day
                int oneDayCost = dp[Math.max(0, currDay - 1)] + costs[0];
                int sevenDayCost = dp[Math.max(0, currDay - 7)] + costs[1];
                int thirtyDayCost = dp[Math.max(0, currDay - 30)] + costs[2];
                dp[currDay] = Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));
            }
        }

        return dp[lastDay];
    }

    // public static int recur(int[] days, int[] costs, int currDay, int[] dp) {
    // // base case
    // if (currDay > days[days.length - 1]) {
    // return 0;
    // }
    // if (dp[currDay] != -1) {
    // return dp[currDay];
    // }
    // if (!set.contains(currDay)) {
    // dp[currDay] = recur(days, costs, currDay + 1, dp);
    // return dp[currDay];
    // }

    // // Calculating the days calls
    // int oneDay = costs[0] + recur(days, costs, currDay + 1, dp);
    // int sevenDay = costs[1] + recur(days, costs, currDay + 7, dp);
    // int thirtyDay = costs[2] + recur(days, costs, currDay + 30, dp);
    // dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    // return dp[currDay];
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Days Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] days = new int[size];

        System.out.println("Enter The Days Array Elements : ");
        for (int i = 0; i < days.length; i++) {
            System.out.printf("%d : ", i);
            days[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The Costs Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] costs = new int[n];

        System.out.println("Enter The Costs Array Size : ");
        for (int i = 0; i < costs.length; i++) {
            System.out.printf("%d : ", i);
            costs[i] = sc.nextInt();
        }
        System.out.println();

        int ans = mincostTickets(days, costs);

        System.out.println(ans);

        sc.close();
    }
}