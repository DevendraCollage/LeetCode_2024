/*
 * LC2037
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC2037 {
    public static int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        // ? This is also works
        // ! Formula-1
        // Arrays.sort(seats);
        // Arrays.sort(students);
        // int n = seats.length;
        // int minMoves = 0;
        // for (int i = 0; i < n; i++) {
        // minMoves += Math.abs(seats[i] - students[i]);
        // }
        // return minMoves;

        // ! Formula-2
        int maxSeat = findMax(seats);
        int maxStudent = findMax(students);
        int seatCount[] = new int[maxSeat + 1];
        int studentCount[] = new int[maxStudent + 1];

        int totalStudent = students.length;
        for (int i = 0; i < totalStudent; i++) {
            seatCount[seats[i]]++;
            studentCount[students[i]]++;
        }

        int moves = 0;
        int i = 0;
        int j = 0;
        while (totalStudent > 0) {
            while (seatCount[i] == 0) {
                i++;
            }
            while (studentCount[j] == 0) {
                j++;
            }
            moves += Math.abs(i - j);
            seatCount[i]--;
            studentCount[j]--;
            totalStudent--;
        }

        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Seats Array Size : ");
        int size1 = sc.nextInt();
        System.out.println();

        int seat[] = new int[size1];

        System.out.println("Enter Seat Elements : ");
        for (int i = 0; i < seat.length; i++) {
            System.out.printf("[%d] : ", i);
            seat[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter Student Array Size : ");
        int size2 = sc.nextInt();
        System.out.println();

        int student[] = new int[size2];

        System.out.println("Enter Student Elements : ");
        for (int i = 0; i < student.length; i++) {
            System.out.printf("[%d] : ", i);
            student[i] = sc.nextInt();
        }
        System.out.println();

        int n = minMovesToSeat(seat, student);

        System.out.println(n);

        sc.close();
    }
}
