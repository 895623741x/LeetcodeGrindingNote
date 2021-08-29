package Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue513 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n)

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            root = queue.poll();

            if(root.right != null) {
                queue.offer(root.right);
            }

            if(root.left != null) {
                queue.offer(root.left);
            }
        }

        return root.val;

    }
}
