/*
 * LC2558
 */

import java.util.*;

public class LC2558 {
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0l;
        for (int gift : gifts) {
            sum += gift;
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            int largest = pq.poll();
            int sq = (int) Math.sqrt(largest);
            sum -= (largest - sq);
            pq.offer(sq);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Gifts Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] gifts = new int[n];

        System.out.println("Enter The Gifts Array Elements : ");
        for (int i = 0; i < gifts.length; i++) {
            System.out.printf("[%d] : ", i);
            gifts[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K Element : ");
        int k = sc.nextInt();
        System.out.println();

        long ans = pickGifts(gifts, k);

        System.out.println(ans);

        sc.close();
    }
}