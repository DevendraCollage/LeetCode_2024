/*
 * LC1367
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC1367 {
    public static boolean dfs(ListNode head, TreeNode node) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (head.val != node.val) {
            return false;
        }
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            if (dfs(head, root)) {
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
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

    public static TreeNode createTreeNode(LinkedList<Integer> elements) {
        if (elements.isEmpty())
            return null;

        TreeNode root = new TreeNode(elements.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < elements.size()) {
            TreeNode current = queue.poll();

            // Add left child
            if (i < elements.size() && elements.get(i) != -1) {
                current.left = new TreeNode(elements.get(i));
                queue.add(current.left);
            }
            i++;

            // Add right child
            if (i < elements.size() && elements.get(i) != -1) {
                current.right = new TreeNode(elements.get(i));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Linked-List ListNode : ");
        int l1size = sc.nextInt();
        System.out.println();

        LinkedList<Integer> head = new LinkedList<>();

        System.out.println("Enter the ListNode Elements : ");
        for (int i = 0; i < l1size; i++) {
            System.out.printf("[%d] : ", i);
            int elem = sc.nextInt();
            head.add(elem);
        }
        ListNode headList = createListNode(head);
        System.out.println();

        System.out.print("Enter the size of the Linked-List TreeNode : ");
        int l2size = sc.nextInt();
        System.out.println();

        LinkedList<Integer> root = new LinkedList<>();

        System.out.println("Enter the TreeNode Elements : ");
        for (int i = 0; i < l2size; i++) {
            System.out.printf("[%d] : ", i);
            int elem = sc.nextInt();
            root.add(elem);
        }
        TreeNode rootList = createTreeNode(root);
        System.out.println();

        boolean ans = isSubPath(headList, rootList);

        System.out.println(ans);

        sc.close();
    }
}