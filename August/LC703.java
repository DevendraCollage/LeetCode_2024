/*
 * LC703
 */

import java.util.PriorityQueue;

public class LC703 {
    PriorityQueue<Integer> pq;
    int k;

    public LC703(int k, int[] num) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : num) {
            add(n);
        }
    }

    public int add(int val) {
        if (pq.size() < k || val > pq.peek()) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}