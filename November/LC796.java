/*
 * LC796
 */

import java.util.*;

public class LC796 {
    private static int[] findLPS(String patt) { // Longest Possible Subsequence
        int n = patt.length();
        int[] lps = new int[n];
        int j = 0;

        for (int i = 1; i < n;) {
            if (patt.charAt(i) == patt.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    public static boolean KMP(String text, String patt, int[] lps) {
        int m = text.length();
        int n = patt.length();
        int i = 0, j = 0;

        while (i < m) {
            if (text.charAt(i) == patt.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {
                return true;
            }
            if (i < m && text.charAt(i) != patt.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String text = s + s;
        int[] lps = findLPS(goal);
        return KMP(text, goal, lps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        System.out.print("Enter The Goal String : ");
        String goal = sc.nextLine();
        System.out.println();

        boolean answer = rotateString(str, goal);

        System.out.println(answer);

        sc.close();
    }
}