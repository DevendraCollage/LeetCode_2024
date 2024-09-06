/*
 * LC3217
 * In this will usage the custom data type like this ListNode
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

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

public class LC3217 {
    public static ListNode modifiedList(int[] nums, ListNode head) {
        boolean set[] = new boolean[(int) 1e5 + 1];
        for (int num : nums) {
            set[num] = true;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (set[curr.val] == true) {
                if (prev == null) {
                    head = head.next;
                    curr.next = null;
                    curr = head;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
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

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();
        System.out.println();

        int arr[] = new int[size];

        System.out.println("Enter the Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter the LinkedList Size : ");
        int LSize = sc.nextInt();
        System.out.println();

        LinkedList<Integer> l = new LinkedList<>();

        System.out.println("Enter the LinkedList Elements : ");
        for (int i = 0; i < LSize; i++) {
            System.out.printf("[%d] : ", i);
            int elem = sc.nextInt();
            l.add(elem);
        }
        System.out.println();

        ListNode head = createListNode(l);

        ListNode modifiedHead = modifiedList(arr, head);

        System.out.println("Modified LinkedList:");
        printList(modifiedHead);

        sc.close();
    }
}