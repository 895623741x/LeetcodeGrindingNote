package Tree;

import javax.swing.tree.TreeNode;

public class BalancedBinaryTree110 {
    // We will need to use recursion to solve this question and we will make it recursive from the bottom to the top.
    // when the root is null, it will be the base case and it returns value 0. the height of the parent node will be
    // 1 + max(leftNode, rightNode). we will also check if the difference of the two subtree is <= 1. if it is not,
    // we return -1. if the result is -1, we know the tree is not balanced and we say it is false, otherwise it is true

    // TC = O(n), n is the number of the nodes in tree
    // SC = O(h), h is the height of the tree
    public boolean isBalanced(TreeNode root) {
        if(helper(root) == -1) {
            return false
        } else {
            return true;
        }
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left); // will be 0 if root is null
        if(left == -1) return -1;
        int right = helper(root.right); // will be 0 if root is null
        if(right == -1) return -1;

        if(Math.abs(left - right) <= 1) {
            return 1 + Math.max(left, right);
        } else {
            return -1;
        }
    }
}
