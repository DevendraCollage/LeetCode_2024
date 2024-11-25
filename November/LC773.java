/*
 * LC773
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LC773 {
    // 1D String representation of the 2D Array
    private static final int[][] dir = {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 3, 5, 1 },
            { 4, 2 },
    };

    public static int slidingPuzzle(int[][] board) {
        // Convert the board to a string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();
        String target = "123450";

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.add(start);
        visited.put(start, 0);

        // BFS loop
        while (!queue.isEmpty()) {
            String state = queue.poll();
            int moves = visited.get(state);

            // If we reach the target, return the number of moves
            if (state.equals(target)) {
                return moves;
            }

            int zeroIdx = state.indexOf('0');
            for (int p : dir[zeroIdx]) {
                String newState = swap(state, zeroIdx, p);

                if (!visited.containsKey(newState)) {
                    queue.add(newState);
                    visited.put(newState, moves + 1);
                }
            }
        }

        // If the target is unreachable
        return -1;
    }

    // Helper function to swap the elements
    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Row : ");
        int row = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] board = new int[row][col];

        System.out.println("Enter The Boards Elements : ");
        for (int i = 0; i < board.length; i++) {
            for (int j = i; j < board.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = slidingPuzzle(board);

        System.out.println(ans);

        sc.close();
    }
}