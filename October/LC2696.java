/*
 * 2696
 */

import java.util.*;

public class LC2696 {
    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (ch == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if (ch == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        str = str.toUpperCase();
        System.out.println();

        int ans = minLength(str);

        System.out.println(ans);

        sc.close();
    }
}