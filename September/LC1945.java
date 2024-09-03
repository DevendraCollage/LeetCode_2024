/*
 * LC1945
 */

import java.util.Scanner;

public class LC1945 {
    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch - 96);
        }
        while (k > 0) {
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                sum += (sb.charAt(i) - '0');
            }
            k--;
            sb = new StringBuilder(String.valueOf(sum));
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String s = sc.nextLine();
        System.out.println();

        System.out.print("Enter k value : ");
        int k = sc.nextInt();

        int ind = getLucky(s, k);

        System.out.println(ind);

        sc.close();
    }
}
