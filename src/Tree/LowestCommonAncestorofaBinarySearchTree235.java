package Tree;

import javax.swing.tree.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree235 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // if nodes are not in the same subtree, we know the LCA is the the root at the top
        return root;
    }
}
