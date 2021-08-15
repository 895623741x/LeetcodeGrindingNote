package Tree;

import javax.swing.tree.TreeNode;

public class TrimaBinarySearchTree669 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n), n is the number of nodes in tree
}
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;

        // if the value of current root is smaller than low, we will check if its right child is greater than low
        // since its left child will only be even smaller
        if(root.val < low) return trimBST(root.right, low, high);

        // if the value of current root is greater than high, we will check if its left child is less than high
        // since its right child will only be even greater
        if(root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
