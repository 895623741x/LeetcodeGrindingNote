package Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree99 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n)
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        TreeNode root1 = null;
        TreeNode root2 = null;

        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).val > list.get(i + 1).val) {
                root2 = list.get(i + 1);

                if(root1 == null) {
                    root1 = list.get(i);
                }
            }

        }

        if(root1 != null && root2 != null) {
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
    }

    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
