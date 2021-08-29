package Tree;

import javax.swing.tree.TreeNode;

public class SumofLeftLeaves404 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n)

    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null) {
            return 0;
        } else if(root.left != null && root.left.left == null && root.left.right == null) {
            root.left.val + sumOfLeftLeaves(root.right);
        } else {
            sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
