package Tree;

import javax.swing.tree.TreeNode;

public class InvertBinaryTree226 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n), n is the number of nodes in tree

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
