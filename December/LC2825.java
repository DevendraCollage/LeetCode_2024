/*
 * LC2825
 */

import java.util.*;

public class LC2825 {
    public static boolean canMakeSubsequence(String str1, String str2) {
        int idx1 = 0, idx2 = 0;
        int n = str1.length();
        int m = str2.length();
        if (m > n) {
            return false;
        }
        while (idx2 < m && idx1 < n) {
            if ((str1.charAt(idx1) == str2.charAt(idx2)) || (str1.charAt(idx1) == str2.charAt(idx2) - 1)
                    || (str1.charAt(idx1) == 'z' && str2.charAt(idx2) == 'a')) {
                idx2++;
            }
            idx1++;
        }

        return idx2 == m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String-1 Here : ");
        String str1 = sc.nextLine();
        System.out.println();

        System.out.print("Enter The String-2 Here : ");
        String str2 = sc.nextLine();
        System.out.println();

        boolean ans = canMakeSubsequence(str1.toLowerCase(), str2.toLowerCase());

        System.out.println(ans);

        sc.close();
    }
}