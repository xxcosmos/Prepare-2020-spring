package problem32;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution3 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(pRoot);
        boolean isReverse = false;
        while (!nodeArrayList.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int length = nodeArrayList.size();
            while (length-- > 0){
                TreeNode a = nodeArrayList.remove(0);;


                if (a == null) continue;
                list.add(a.val);
                nodeArrayList.add(a.left);
                nodeArrayList.add(a.right);
            }
            if (isReverse){
                Collections.reverse(list);
            }
            isReverse = !isReverse;
            if (list.size() != 0)
                result.add(list);
        }

        return result;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
