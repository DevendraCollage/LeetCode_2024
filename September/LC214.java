/*
 * LC214
 */

import java.util.*;

public class LC214 {
    public static String shortestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return s;
        }
        int left = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(left)) {
                left++;
            }
        }

        if (left == len) {
            return s;
        }

        String nonPan = s.substring(left);
        StringBuilder revSuf = new StringBuilder(nonPan).reverse();

        return revSuf.append(shortestPalindrome(s.substring(0, left))).append(nonPan).toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String  : ");
        String str = sc.nextLine();
        System.out.println();

        String ans = shortestPalindrome(str);

        System.out.println(ans);

        sc.close();
    }
}