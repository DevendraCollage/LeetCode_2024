/*
 * LC881
 */

import java.util.*;

public class LC881 {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter the Limit : ");
        int limit = sc.nextInt();
        System.out.println();

        int n = numRescueBoats(arr, limit);

        System.out.println(n);

        sc.close();
    }
}