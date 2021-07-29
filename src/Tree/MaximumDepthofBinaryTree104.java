package Tree;

import javax.swing.tree.TreeNode;

public class MaximumDepthofBinaryTree104 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n), which is the worst case

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = 1;
        int rightHeight = 1;

        leftHeight += maxDepth(root.left);
        rightHeight += maxDepth(root.right);

        return Math.max(leftHeight, rightHeight);
    }
}
