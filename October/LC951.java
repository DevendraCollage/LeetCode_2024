/*
 * LC951
 */

public class LC951 {
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        // original case
        boolean isSame = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        if (isSame) {
            return true;
        }
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}