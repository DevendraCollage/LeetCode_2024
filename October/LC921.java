/*
 * LC921
 */

import java.util.*;

public class LC921 {
    public static int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                if (open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        return open + close;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your String Here : ");
        String str = sc.nextLine();
        System.out.println();

        int ans = minAddToMakeValid(str);

        System.out.println(ans);

        sc.close();
    }
}