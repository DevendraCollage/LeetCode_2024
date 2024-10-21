/*
 * LC1106
 */

import java.util.*;

public class LC1106 {
    public static char evaluate(ArrayList<Character> list, char op) {
        if (op == '&') { // and operator
            if (find(list, 'f')) {
                return 'f';
            } else {
                return 't';
            }
        } else if (op == '|') { // or operator
            if (find(list, 't')) {
                return 't';
            } else {
                return 'f';
            }
        } else if (op == '!') { // not operator
            return (list.get(0) == 't' ? 'f' : 't');
        } else {
            return 'f'; // default case, should not occur
        }
    }

    public static boolean find(ArrayList<Character> list, char val) {
        for (char ch : list) {
            if (ch == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == ')') {
                ArrayList<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop(); // remove '('
                char op = stack.pop();
                char ans = evaluate(list, op);
                stack.push(ans);
            } else {
                if (ch != ',') {
                    stack.push(ch);
                }
            }
        }
        return stack.peek() == 't';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        Boolean ans = parseBoolExpr(str);

        System.out.println(ans);

        sc.close();
    }
}