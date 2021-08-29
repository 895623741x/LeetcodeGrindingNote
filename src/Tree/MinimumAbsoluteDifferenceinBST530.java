package Tree;

import javax.swing.tree.TreeNode;

public class MinimumAbsoluteDifferenceinBST530 {
    // we can always use INORDER traversal to get a sorted array of a binary search tree. In this question, we use
    // inorder traversal to get the value of node from the smallest to the biggest so that (root.val - pre) will
    // always be positive

    // TC = O(n), n is the number of nodes in tree
    // SC = O(n), where n is the depth of the tree

    int ans;
    int pre;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);

        if(pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }

        dfs(root.right);
    }
}
