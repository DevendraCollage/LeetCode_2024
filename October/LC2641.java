/*
 * LC2641
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LC2641 {
    public static TreeNode replaceValueInTree(TreeNode root) {
        // BFS (Breadth First Search)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int preSum = root.val;
        // ArrayList<Integer> levelSum = new ArrayList<>();
        // pass-1
        // while (!queue.isEmpty()) {
        // int size = queue.size();
        // int sum = 0;
        // for (int i = 0; i < size; i++) {
        // TreeNode node = queue.poll();
        // sum += node.val;
        // if (node.left != null) {
        // queue.offer(node.left);
        // }

        // if (node.right != null) {
        // queue.offer(node.right);
        // }
        // }
        // levelSum.add(sum);
        // }

        // pass-2
        // queue.offer(root);
        // root.val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int curSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                node.val = preSum - node.val;
                int sibSum = 0;
                if (node.left != null) {
                    sibSum += node.left.val;
                }

                if (node.right != null) {
                    sibSum += node.right.val;
                }
                // sum += node.val;
                if (node.left != null) {
                    curSum += node.left.val;
                    node.left.val = sibSum;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    curSum += node.right.val;
                    node.right.val = sibSum;
                    queue.offer(node.right);
                }
            }
            preSum = curSum;
        }

        return root;
    }
}