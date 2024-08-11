/*
 * LC2053
 */

import java.util.HashSet;
import java.util.Scanner;

public class LC2053 {
    public static String kthDistinct(String[] arr, int k) {
        HashSet<String> distinct = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();
        for (String str : arr) {
            if (duplicate.contains(str)) {
                continue;
            }
            if (distinct.contains(str)) {
                distinct.remove(str);
                duplicate.add(str);
            } else {
                distinct.add(str);
            }
        }
        for (String str : arr) {
            if (!duplicate.contains(str)) {
                k--;
            }
            if (k == 0) {
                return str;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the Array : ");
        int size = sc.nextInt();
        System.out.println();

        String arr[] = new String[size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.next();
        }
        System.out.println();

        System.out.print("Enter the Kth Index : ");
        int kth = sc.nextInt();

        String dis = kthDistinct(arr, kth);

        System.out.println(dis);

        sc.close();
    }
}