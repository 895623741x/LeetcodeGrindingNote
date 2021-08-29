package Tree;

import javax.swing.tree.TreeNode;

public class ConvertBSTtoGreaterTree538 {
    // TC = O(n), n is the number of nodes in tree
    //SC = O(n)
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int sum) {
        if(root == null) return sum;

        root.val += dfs(root.right, sum);
        return dfs(root.left, root.val);
    }
}
