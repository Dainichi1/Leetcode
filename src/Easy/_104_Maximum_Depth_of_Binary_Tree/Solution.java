package Easy._104_Maximum_Depth_of_Binary_Tree;


// Definition for a binary tree node.
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
    public int maxDepth(TreeNode root) {
        // Caso base: albero vuoto
        if (root == null) return 0;

        // Calcolo la profondità massima del sotto albero sinistro
        int leftDepth = maxDepth(root.left);

        // Calcolo la profondità massima del sotto albero destro
        int rightDepth = maxDepth(root.right);

        // Profondità del nodo corrente = 1 (questo nodo) + max tra sinistra e destra
        return 1 + Math.max(leftDepth, rightDepth);
    }
}