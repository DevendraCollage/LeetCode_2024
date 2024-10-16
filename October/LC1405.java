/*
 * LC1405
 */

import java.util.*;

class Pair implements Comparable<Pair> {
    int count;
    char ch;

    Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }

    public int compareTo(Pair that) { // return the decreasing order of count
        return that.count - this.count;
    }
}

public class LC1405 {
    public static String longestDiverseString(int a, int b, int c) {
        // create a pq (decreasing order of element count)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        if (a > 0) {
            pq.offer(new Pair(a, 'a'));
        }
        if (b > 0) {
            pq.offer(new Pair(b, 'b'));
        }
        if (c > 0) {
            pq.offer(new Pair(c, 'c'));
        }

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int n = res.length();
            char ch = node.ch;
            int count = node.count;

            // if current element is same as last two then push the second highest freq
            // element
            if (n >= 2 && res.charAt(n - 1) == ch && res.charAt(n - 2) == ch) {
                if (pq.isEmpty()) {
                    break;
                }
                Pair sec = pq.poll();
                res.append(sec.ch);
                sec.count--;
                if (sec.count > 0) {
                    pq.offer(new Pair(sec.count, sec.ch));
                }
            } else {
                res.append(node.ch);
                node.count--;
            }
            // if element count is not 0, insert in pq with update count
            if (node.count > 0) {
                pq.offer(new Pair(node.count, node.ch));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter A : ");
        int a = sc.nextInt();
        System.out.println();

        System.out.print("Enter B : ");
        int b = sc.nextInt();
        System.out.println();

        System.out.print("Enter C : ");
        int c = sc.nextInt();
        System.out.println();

        String ans = longestDiverseString(a, b, c);

        System.out.println(ans);

        sc.close();
    }
}