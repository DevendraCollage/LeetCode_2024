/*
 * LC515
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LC515 {
    public static List<Integer> largestValues(TreeNode root) {
        // Storing answer
        List<Integer> ans = new ArrayList<>();
        // Base case
        if (root == null) {
            return ans;
        }
        // Use for BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                // If left of tree will not be null add
                if (cur.left != null) {
                    q.add(cur.left);
                }
                // If right of tree will not be null add
                if (cur.right != null) {
                    q.add(cur.right);
                }
                max = Math.max(max, cur.val);
            }
            ans.add(max);
        }
        return ans;
    }
}