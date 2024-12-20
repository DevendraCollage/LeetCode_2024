import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LC2415 {
    public static TreeNode reverseOddLevels(TreeNode root) {
        // Base Case
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        // While queue is not empty
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<TreeNode> list = new ArrayList<>();
            // Level of traversal
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) { // if have an left node insert into queue
                    queue.offer(node.left);
                }
                if (node.right != null) { // if have an right node insert into queue
                    queue.offer(node.right);
                }
                if (level % 2 != 0) { // if have odd nodes
                    list.add(node);
                }
            }

            if (level % 2 != 0) {
                // two pointer approach
                int r = 0;
                int l = list.size() - 1;
                while (r < l) {
                    // if right less than left then swap it nodes
                    int temp = list.get(r).val;
                    list.get(r).val = list.get(l).val;
                    list.get(l).val = temp;
                    r++;
                    l--;
                }
            }
            level++;
        }

        return root;
    }
}