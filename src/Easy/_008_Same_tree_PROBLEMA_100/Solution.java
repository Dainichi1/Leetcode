package Easy._008_Same_tree_PROBLEMA_100;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 1) Se entrambi sono null, sono uguali in questo punto
        if (p == null && q == null) return true;

        // 2) Se uno è null e l'altro no, forma diversa
        if (p == null || q == null) return false;

        // 3) Se i valori sono diversi, alberi diversi
        if (p.val != q.val) return false;

        // 4) Ricorsione: devono essere uguali sia a sinistra che a destra
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
