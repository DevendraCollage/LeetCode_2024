/*
 * LC2109
 */

import java.util.*;

public class LC2109 {
    public static String addSpaces(String s, int[] spaces) {
        // Two Pointer Approach
        int n = s.length();
        int m = spaces.length;
        StringBuilder sb = new StringBuilder(n + m);
        int spaceIndex = 0;
        for (int i = 0; i < n; i++) {
            if (spaceIndex < m && spaces[spaceIndex] == i) {
                sb.append(' ');
                spaceIndex++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String s = sc.nextLine();
        System.out.println();

        System.out.print("Enter Spaces Array Length : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter Spaces Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        String ans = addSpaces(s, arr);

        System.out.println(ans);

        sc.close();
    }
}