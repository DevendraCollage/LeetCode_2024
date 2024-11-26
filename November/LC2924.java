/*
 * LC2924
 */

import java.util.*;

public class LC2924 {
    public static int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        int ans = -1, counter = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                ans = i;
                counter++;
            }
        }

        if (counter == 1) {
            return ans;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Edges Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[][] edges = new int[size][size];

        System.out.println("Enter The Edges Array Elements : ");
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = findChampion(n, edges);

        System.out.println(ans);

        sc.close();
    }
}