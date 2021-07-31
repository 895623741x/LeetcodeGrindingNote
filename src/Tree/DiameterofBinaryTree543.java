package Tree;

import javax.swing.tree.TreeNode;

public class DiameterofBinaryTree543 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(h), h is the height of the tree

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        diameter = Math.max(left + right, diameter);
        return 1 + Math.max(left, right);
    }
}
