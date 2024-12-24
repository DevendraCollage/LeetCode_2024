import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class LC3203 {
    private static int findDiameter(int[][] edges) {
        // Base case
        if (edges.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Build adjacency list
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Find any node in the graph (since it's undirected)
        int anyNode = adj.keySet().iterator().next();

        return diameter(adj, anyNode);
    }

    private static int diameter(Map<Integer, List<Integer>> adj, int startNode) {
        // First BFS to find the farthest node
        int[] bfsResult1 = bfs(startNode, adj);

        // Second BFS from the farthest node to calculate the diameter
        int[] bfsResult2 = bfs(bfsResult1[0], adj);

        return bfsResult2[1];
    }

    // Helper function to do the BFS
    private static int[] bfs(int start, Map<Integer, List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int farthestNode = start;
        int distance = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                farthestNode = curr;
                for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return new int[] { farthestNode, distance };
    }

    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int dist1 = findDiameter(edges1);
        int dist2 = findDiameter(edges2);

        int radius1 = (dist1 + 1) / 2;
        int radius2 = (dist2 + 1) / 2;

        int sum = 1 + radius1 + radius2;
        return Math.max(sum, Math.max(dist1, dist2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of edges for the first tree:");
        int r1 = sc.nextInt();
        int[][] edges1 = new int[r1][2];
        System.out.println("Enter the edges for the first tree (as pairs of nodes):");
        for (int i = 0; i < r1; i++) {
            edges1[i][0] = sc.nextInt();
            edges1[i][1] = sc.nextInt();
        }

        System.out.println("Enter the number of edges for the second tree:");
        int r2 = sc.nextInt();
        int[][] edges2 = new int[r2][2];
        System.out.println("Enter the edges for the second tree (as pairs of nodes):");
        for (int i = 0; i < r2; i++) {
            edges2[i][0] = sc.nextInt();
            edges2[i][1] = sc.nextInt();
        }

        int ans = minimumDiameterAfterMerge(edges1, edges2);
        System.out.println("The minimum diameter after merging the trees is: " + ans);

        sc.close();
    }
}
