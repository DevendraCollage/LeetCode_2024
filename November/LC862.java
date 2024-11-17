/*
 * LC862
 */

import java.util.*;

class Value {
    long ps;
    int idx;

    public Value(long ps, int idx) {
        this.ps = ps;
        this.idx = idx;
    }
}

public class LC862 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        long sum = 0;

        PriorityQueue<Value> pq = new PriorityQueue<Value>(
                (a, b) -> Long.compare(a.ps, b.ps));

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum >= k) {
                ans = Math.min(ans, i + 1);
            }

            while (!pq.isEmpty() && sum - pq.peek().ps >= k) {
                Value piece = pq.poll();
                ans = Math.min(ans, i - piece.idx);
            }

            pq.offer(new Value(sum, i));
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The k Elements : ");
        int k = sc.nextInt();
        System.out.println();

        int answer = shortestSubarray(arr, k);

        System.out.println(answer);

        sc.close();
    }
}