package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author varg
 * @date 2020/11/10 13:46
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        String path = "";
        dfs(root, path, result);

        return result;

    }

    private void dfs(TreeNode root, String path, List<String> result) {

        if (root != null) {
            path = path + root.val;
            // leaf node
            if (root.left == null && root.right == null) {
                result.add(path);
            } else {
                // not leaf node
                path = path + "->";
                dfs(root.left, path, result);
                dfs(root.right, path, result);
            }
        }
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
