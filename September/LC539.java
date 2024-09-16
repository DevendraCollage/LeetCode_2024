/*
 * LC539
 */

import java.util.*;
import java.time.format.DateTimeParseException;

public class LC539 {
    public static int findMinDifference(List<String> timePoints) {
        boolean mins[] = new boolean[24 * 60];
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            int minutes = h * 60 + m;
            if (mins[minutes]) {
                return 0;
            }
            mins[minutes] = true;
        }

        int prev = -1;
        int firstVal = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int cur = 0; cur < 1440; cur++) {
            if (mins[cur]) {
                if (prev == -1) {
                    firstVal = cur;
                    prev = cur;
                } else {
                    minDiff = Math.min(minDiff, cur - prev);
                    prev = cur;
                }
            }
        }

        if (prev != -1) {
            minDiff = Math.min(minDiff, 1440 + firstVal - prev);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of List : ");
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println();

        List<String> l1 = new ArrayList<>();

        System.out.println("Enter List Elements : ");
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d] : ", i);
            String elem = sc.nextLine();
            try {
                // LocalTime time = LocalTime.parse(elem);
                l1.add(elem);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm format.");
                i--;
            }
        }
        System.out.println();

        int answer = findMinDifference(l1);

        System.out.println(answer);

        sc.close();
    }
}