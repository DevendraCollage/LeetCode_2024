/*
 * LC2490
 */

import java.util.Scanner;

public class LC2490 {
    public static boolean isCircularSentence(String sentence) {
        int n = sentence.length();

        for (int i = 0; i < n; i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                return false;
            }
        }

        return sentence.charAt(0) == sentence.charAt(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        boolean answer = isCircularSentence(str);

        System.out.println(answer);

        sc.close();
    }
}