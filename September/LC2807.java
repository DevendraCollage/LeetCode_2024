/*
 * LC2807
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

public class LC2807 {
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            int max = Math.max(curr.val, curr.next.val);
            int min = Math.min(curr.val, curr.next.val);
            int gcd = findGCD(max, min);
            ListNode gcdNode = new ListNode(gcd);
            gcdNode.next = curr.next;
            curr.next = gcdNode;
            curr = gcdNode.next;
        }
        return head;
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

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Size of LinkedList : ");
        int size = sc.nextInt();
        System.out.println();

        LinkedList<Integer> l1 = new LinkedList<>();

        System.out.println("Enter the LinkedList Elements : ");
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d] : ", i);
            int elem = sc.nextInt();
            l1.add(elem);
        }
        ListNode headList = createListNode(l1);
        System.out.println();

        ListNode answer = insertGreatestCommonDivisors(headList);

        printList(answer);

        sc.close();
    }
}