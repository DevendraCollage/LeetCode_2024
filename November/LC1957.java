/*
 * LC1957
 */

import java.util.Scanner;

public class LC1957 {
    public static String makeFancyString(String s) {
        // Base Case
        if (s.length() < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));
        sb.append(s.charAt(1));

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        String answer = makeFancyString(str);

        System.out.println(answer);

        sc.close();
    }
}
