package Tree;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class SubtreeofAnotherTree572 {
    // TC = O(m * n), m is the number of nodes in root and n is the number of nodes in subRoot
    // SC = O(min(m, n)), because how deep out recursion goes is going to be whichever tree has less nodes

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) return true;
        if (root == null) return false;

        if(isSameTree(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }


    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if(root.val == subRoot.val) {
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        } else {
            return false;
        }



    }
}
