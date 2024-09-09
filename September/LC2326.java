/*
 * LC2326
 */

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LC2326 {
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int topRow = 0, bottomRow = m - 1, leftCol = 0, rightCol = n - 1;
        while (head != null) {
            for (int i = leftCol; i <= rightCol; i++) {
                if (head == null) {
                    break;
                }
                matrix[topRow][i] = head.val;
                head = head.next;
            }
            topRow++;

            for (int j = topRow; j <= bottomRow; j++) {
                if (head == null) {
                    break;
                }
                matrix[j][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;

            for (int j = rightCol; j >= leftCol; j--) {
                if (head == null) {
                    break;
                }
                matrix[bottomRow][j] = head.val;
                head = head.next;
            }
            bottomRow--;

            for (int j = bottomRow; j >= topRow; j--) {
                if (head == null) {
                    break;
                }
                matrix[j][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;
        }
        return matrix;
    }

    public static ListNode createListNode(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Row Size : ");
        int row = sc.nextInt();
        System.out.print("Enter the Column Size : ");
        int column = sc.nextInt();
        System.out.println();

        LinkedList<Integer> l1 = new LinkedList<>();

        System.out.print("Enter the Size of LinkedList : ");
        int lsize = sc.nextInt();
        System.out.println();

        System.out.println("Enter LinkedList Elements : ");
        for (int i = 0; i < lsize; i++) {
            System.out.printf("[%d] : ", i);
            int elem = sc.nextInt();
            l1.add(elem);
        }
        ListNode headList = createListNode(l1);
        System.out.println();

        int arr[][] = spiralMatrix(row, column, headList);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("[%d][%d] : %d\t", i, j, arr[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}