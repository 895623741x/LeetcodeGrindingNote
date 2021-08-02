package Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class DeleteNodesAndReturnForest1110 {
    // TC = O(n), n is the number of the nodes in tree
    // SC = O(n), n is the number of the nodes in tree
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> remaining = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int i: to_delete) {
            toDelete.add(i);
        }

        removeNodes(root, remaining, toDelete);

        if(!toDelete.contains(root.val)) {
            remaining.add(root);
        }

        return remaining;
    }

    public TreeNode removeNodes(TreeNode root, List<TreeNode> remaining, Set<Integer> toDelete) {
        if(root == null) return null;

        root.left = removeNodes(root.left, remaining, toDelete);
        root.right = removeNodes(root.right, remaining, toDelete);

        if(toDelete.contains(root.val)) {
            if(root.left != null) {
                remaining.add(root.left);
            }

            if(toDelete.contains(root.right)) {
                remaining.add(root.right);
            }

            root = null;
        }

        return root;
    }
}
