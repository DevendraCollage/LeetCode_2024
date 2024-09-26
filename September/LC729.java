/*
 * LC729
 */

import java.util.*;

class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer preVal = map.lowerKey(end);
        if (preVal != null && start <= map.get(preVal) - 1) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}

public class LC729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Array-1 Size : ");
        int size = sc.nextInt();
        System.out.println();

        String arr[] = new String[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextLine();
        }
        System.out.println();

        System.out.print("Enter the Array-2D Size : ");
        int size1 = sc.nextInt();
        System.out.println();

        int ar[][] = new int[size][size];

        System.out.println("Enter 2-D Array Elements : ");
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                ar[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        sc.close();
    }
}