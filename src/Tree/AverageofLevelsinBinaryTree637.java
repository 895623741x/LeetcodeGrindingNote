package Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree637 {
    // We will use queue for the BFS question
    // TC = O(n), n is the number of the nodes in tree,    SC = O(n), n is the number of the nodes in tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return res;

        // add the first root to the tree
        queue.offer(root);

        while(!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                // get the first node out of the queue and add its value to the sum
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }

            }

            double average = sum / size;
            res.add(average);
        }

        return res;
    }
}
