package Easy._018_Invert_Binary_tree_PROBLEMA_226;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode leftInverted  = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        root.left  = rightInverted;
        root.right = leftInverted;

        return root;
    }
}

