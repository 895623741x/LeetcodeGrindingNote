package Tree;

import javax.swing.tree.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    // TC = O(n), n is the number of nodes in tree
    // SC = O(n), n is the number of nodes in tree

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length - 1 || inStart > inEnd) return null;

        int inIndex = 0;
        for(int i = preStart; i <= inEnd; i++) {
            if(root.val == inorder[i]) {
                inIndex = i;
            }
        }

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);

        // preStart + inIndex - inStart + 1 is written because we want to ignore the left subtree
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}
