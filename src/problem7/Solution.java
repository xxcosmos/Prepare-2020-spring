package problem7;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    1. 前序排列顺序为 根-左-右，中序排列为左-根-右。
//    2. 那么如题根为1。
//    3. 则根据中序遍历序列则可以得到左子树{4,7,2,}和右子树{5,3,8,6}。
//    4. 又根据前序遍历则可以得到左子树的根为2，右子树的根为3。
//    5. 重复3,4步。
//
//    直到左右子树皆为空时即可重建二叉树
//
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstruct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {

                root.left = reConstruct(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstruct(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
