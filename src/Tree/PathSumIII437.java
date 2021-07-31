package Tree;

import javax.swing.tree.TreeNode;

public class PathSumIII437 {
    // TC = O(n^2)

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        int rootCount = helper(root, targetSum);
        int leftRootCount = pathSum(root.left, targetSum);
        int rightRootCount = pathSum(root.right, targetSum);

        return rootCount + leftRootCount + rightRootCount;
    }

    public int helper(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int count = 0;
        if(root.val == targetSum) {
            count++;
        }

        return count + helper(root.left, targetSum - root.val) + helper(root.right, targetSum - root.val);
    }
}
