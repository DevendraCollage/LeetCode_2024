/*
 * LC2872
 */

import java.util.*;

public class LC2872 {
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // create the adjacency list from edges
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        // Iterate the edges
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }
        int[] componentCount = new int[1];
        dfs(0, -1, adjList, values, k, componentCount);
        return componentCount[0];
    }

    // Depth First Search (DFS Time Complexity O(n))
    public static long dfs(int currentNode, int parentNode, List<Integer>[] adjList, int[] nodeValues, int k,
            int[] componentCount) {
        long sum = nodeValues[currentNode];
        for (int neighborNode : adjList[currentNode]) {
            if (neighborNode != parentNode) {
                // check the sum
                sum += dfs(neighborNode, currentNode, adjList, nodeValues, k, componentCount);
            }
        }

        if (sum % k == 0) {
            componentCount[0]++;
            sum = 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Row : ");
        int row = sc.nextInt();
        System.out.print("Enter The Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] edges = new int[row][col];

        System.out.println("Enter The Edges Array Elements : ");
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.print("Enter The Values Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int[] values = new int[size];

        System.out.println("Enter The Values Array Elements : ");
        for (int i = 0; i < values.length; i++) {
            System.out.printf("[%d] : ", i);
            values[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The k : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = maxKDivisibleComponents(n, edges, values, k);

        System.out.println(ans);

        sc.close();
    }
}