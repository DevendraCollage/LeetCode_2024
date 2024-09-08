/*
 * LC725
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

public class LC725 {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        ListNode res[] = new ListNode[k];
        temp = head;
        int avg = size / k;
        int extra = size % k;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                break;
            }
            ListNode currHead = temp;
            ListNode prev = null;
            int len = 0;
            while (temp != null && len < avg) {
                prev = temp;
                temp = temp.next;
                len++;
            }
            if (extra > 0) {
                prev = temp;
                temp = temp.next;
                extra--;
            }
            prev.next = null;
            res[i] = currHead;
        }
        return res;
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

    public static void printListNode(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Size of Linked-list : ");
        int size = sc.nextInt();
        System.out.println();

        LinkedList<Integer> l1 = new LinkedList<>();

        System.out.println("Enter the Elements : ");
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d] : ", i);
            int elem = sc.nextInt();
            l1.add(elem);
        }
        ListNode headList = createListNode(l1);
        System.out.println();

        System.out.print("Enter the k size : ");
        int k = sc.nextInt();
        System.out.println();

        ListNode[] result = splitListToParts(headList, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print("Part " + (i + 1) + ": ");
            printListNode(result[i]);
        }

        sc.close();
    }
}