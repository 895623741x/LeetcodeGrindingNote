package Tree;

import javax.swing.tree.TreeNode;

public class SymmetricTree101 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n), n is the number of nodes in tree;

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            // we want to make sure both roots are null
            return left == right;
        }

        if(left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
