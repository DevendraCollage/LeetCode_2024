/*
 * LC1475
 * Using the Monotonic Stack Pattern
 */

import java.util.*;

public class LC1475 {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            int val = prices[i];
            if (!stack.isEmpty()) {
                prices[i] -= stack.peek();
            }
            stack.push(val);
        }
        return prices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Prices Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] prices = new int[n];

        System.out.println("Enter The Prices Array Elements : ");
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%d : ", i);
            prices[i] = sc.nextInt();
        }
        System.out.println();

        int[] ans = finalPrices(prices);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}