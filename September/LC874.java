/*
 * LC874
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LC874 {
    public static int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] curPos = { 0, 0 };
        int res = 0;
        int curDir = 0;
        HashMap<Integer, HashSet<Integer>> obstacleMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            if (!obstacleMap.containsKey(obstacle[0])) {
                obstacleMap.put(obstacle[0], new HashSet<>());
            }
            obstacleMap.get(obstacle[0]).add(obstacle[1]);

        }

        for (int command : commands) {
            if (command == -1) {
                curDir = (curDir + 1) % 4;
                continue;
            }
            if (command == -2) {
                curDir = (curDir - 1);
                if (curDir == -1) {
                    curDir = 3;
                }
                continue;
            }

            int[] direction = directions[curDir];
            for (int i = 0; i < command; i++) {
                int nextX = curPos[0] + direction[0];
                int nextY = curPos[1] + direction[1];
                if (obstacleMap.containsKey(nextX) && obstacleMap.get(nextX).contains(nextY)) {
                    break;
                }
                curPos[0] = nextX;
                curPos[1] = nextY;
            }

            res = Math.max(res, curPos[0] * curPos[0] + curPos[1] * curPos[1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of Commands Array : ");
        int size1 = sc.nextInt();
        System.out.println();

        int commands[] = new int[size1];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < commands.length; i++) {
            System.out.printf("[%d] : ", i);
            commands[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter size of Obstacles Array : ");
        int size2 = sc.nextInt();
        System.out.println();

        int obstacles[][] = new int[size2][size2];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                obstacles[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int robot = robotSim(commands, obstacles);

        System.out.println(robot);

        sc.close();
    }
}