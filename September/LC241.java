/*
 * LC241
 */

import java.util.*;

public class LC241 {
    public static List<Integer> recur(String exp, int start, int end) {
        List<Integer> res = new ArrayList<>();
        // Base case
        if (start == end) {
            int num = exp.charAt(start) - '0';
            res.add(num);
            return res;
        }

        if (end - start == 1 && Character.isDigit(exp.charAt(start))) {
            // int num1 = exp.charAt(start) - '0';
            // int num2 = exp.charAt(end) - '0';
            int num = Integer.parseInt(exp.substring(start, end + 1));
            res.add(num);
            return res;
        }

        for (int i = start; i <= end; i++) {
            if (Character.isDigit(exp.charAt(i))) {
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = recur(exp, start, i - 1);
            List<Integer> right = recur(exp, i + 1, end);
            for (int l : left) {
                for (int r : right) {
                    if (op == '*') {
                        res.add(l * r);
                    } else if (op == '+') {
                        res.add(l + r);
                    } else {
                        res.add(l - r);
                    }
                }
            }
        }
        return res;
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return recur(expression, 0, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String Here : ");
        String str = sc.nextLine();
        System.out.println();

        List<Integer> ans = diffWaysToCompute(str);

        System.out.println(ans.toString());

        sc.close();
    }
}