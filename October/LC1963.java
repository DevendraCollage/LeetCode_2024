/*
 * LC1963
 */

import java.util.*;

public class LC1963 {
    public static int minSwaps(String s) {
        // Unoptimized way using Stack
        // Stack<Character> stack = new Stack<>();

        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                // stack.push(ch);
                open++;
            } else {
                // if (stack.isEmpty() || stack.peek() == ']') {
                // stack.push(ch);
                // } else {
                // stack.pop();
                // }
                if (open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        // int totalBrackets = stack.size();
        // int closedBrackets = totalBrackets / 2;
        return (close + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        int ans = minSwaps(str);

        System.out.println(ans);

        sc.close();
    }
}