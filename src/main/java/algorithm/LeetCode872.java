package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author varg
 * @date 2020/11/10 11:00
 */
public class LeetCode872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();

        dfs(root1, tree1);
        dfs(root2, tree2);

        if (tree1.size() != tree2.size()) {
            return false;
        }

        for (int i = 0; i < tree1.size(); i++) {
            if (!tree1.get(i).equals(tree2.get(i))) {
                return false;
            }
        }
        return true;

    }

    private void dfs(TreeNode root, List<Integer> list) {


        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }

    }

}