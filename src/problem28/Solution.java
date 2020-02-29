package problem28;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        return isSymmetrical2(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical2(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return (isSymmetrical2(left.left, right.right) && isSymmetrical2(left.right, right.left));
    }
}