/*
 * LC440
 */

import java.util.*;

public class LC440 {
    private static int countSteps(int curr, int n) {
        long steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return (int) steps;
    }

    public static int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = countSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n Size : ");
        int n = sc.nextInt();
        System.out.print("Enter Find Element k index : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = findKthNumber(n, k);

        System.out.println(ans);

        sc.close();
    }
}