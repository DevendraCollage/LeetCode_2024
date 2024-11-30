/*
 * LC2097
 */

import java.util.*;

public class LC2097 {
    public int[][] validArrangement(int[][] pairs) {
        List<int[]> ans = new ArrayList<>();
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (int[] pair : pairs) {
            final int start = pair[0];
            final int end = pair[1];
            graph.putIfAbsent(start, new ArrayDeque<>());
            graph.get(start).push(end);
            outDegree.merge(start, 1, Integer::sum);
            inDegrees.merge(end, 1, Integer::sum);
        }

        final int startNode = getStartNode(graph, outDegree, inDegrees, pairs);
        euler(graph, startNode, ans);
        Collections.reverse(ans);
        return ans.stream().toArray(int[][]::new);
    }

    private int getStartNode(Map<Integer, Deque<Integer>> graph, Map<Integer, Integer> outDegree,
            Map<Integer, Integer> inDegrees, int[][] pairs) {
        for (final int u : graph.keySet())
            if (outDegree.getOrDefault(u, 0) - inDegrees.getOrDefault(u, 0) == 1)
                return u;
        return pairs[0][0]; // Arbitrarily choose a node.
    }

    private void euler(Map<Integer, Deque<Integer>> graph, int u, List<int[]> ans) {
        Deque<Integer> stack = graph.get(u);
        while (stack != null && !stack.isEmpty()) {
            final int v = stack.pop();
            euler(graph, v, ans);
            ans.add(new int[] { u, v });
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.println();

        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] pairs = new int[row][col];

        System.out.println("Enter Pairs Array Elements : ");
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                pairs[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[][] ans = validArrangement(pairs);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.printf("%d ", ans[i][j]);
            }
        }

        sc.close();
    }
}