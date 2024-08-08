import java.util.*;

public class LC885 {
    public static int[][] spiralMatrixIII(int row, int cols, int rStart, int cStart) {
        int directions[][] = {
                { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
        };
        int n = row * cols;
        int res[][] = new int[n][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        int count = 1;
        int step = 1;
        int index = 0;
        while (count < n) {
            for (int times = 0; times < 2; times++) {
                int dr = directions[index % 4][0];
                int dc = directions[index % 4][1];
                for (int i = 0; i < step; i++) {
                    rStart += dr;
                    cStart += dc;
                    if (rStart >= 0 && rStart < row && cStart >= 0 && cStart < cols) {
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        count++;
                    }
                }
                index++;
            }
            step++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Row : ");
        int row = sc.nextInt();
        System.out.print("Enter the Column : ");
        int column = sc.nextInt();
        System.out.print("Start Point Of Row : ");
        int rStart = sc.nextInt();
        System.out.print("End Point Of Column : ");
        int cStart = sc.nextInt();

        int arr[][] = spiralMatrixIII(row, column, rStart, cStart);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(i + ", " + j);
            }
            System.out.println();
        }

        sc.close();
    }
}
