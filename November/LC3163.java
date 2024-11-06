/*
 * LC3163
 */

import java.util.*;

public class LC3163 {
    public static String compressedString(String word) {
        StringBuilder res = new StringBuilder();

        int left = 0,
                len = word.length();

        while (left < len) {
            char curr = word.charAt(left);

            int right = left + 1;

            while (right < len && word.charAt(right) == curr) {
                right = right + 1;
            }

            int count = right - left;

            int numNines = count / 9;

            for (int i = 0; i < numNines; i++) {
                res.append(9);
                res.append(curr);
            }

            int mod9 = count % 9;

            if (mod9 != 0) {
                res.append(mod9);
                res.append(curr);
            }

            left = right;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        String answer = compressedString(str);

        System.out.println(answer);

        sc.close();
    }
}
