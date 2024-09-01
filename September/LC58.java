/*
 * LC58
 */

import java.util.Scanner;

public class LC58 {
    public static int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            // handle the space
            if (s.charAt(i) == ' ') {
                if (len == 0) {
                    i--;
                } else {
                    break;
                }
            } else {
                len++;
                i--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String Here : ");
        String str = sc.nextLine();
        System.out.println();

        int len = lengthOfLastWord(str);

        System.out.println(len);

        sc.close();
    }
}
