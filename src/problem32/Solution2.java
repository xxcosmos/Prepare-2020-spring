package problem32;

import java.util.ArrayList;

public class Solution2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(pRoot);
        while (!list.isEmpty()){
            int length = list.size();
            ArrayList<Integer>ans = new ArrayList<>();
            while (length-- > 0){
                TreeNode a = list.remove(0);
                if (a == null) continue;
                ans.add(a.val);
                list.add(a.left);
                list.add(a.right);
            }
            if (ans.size() != 0)
                result.add(ans);
        }
        return result;
    }

}
