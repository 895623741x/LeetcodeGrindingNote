package Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n), //
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if(root == null) return;

        res.add(root.val);

        preorder(root.left, res);
        preorder(root.right, res);
    }
}
