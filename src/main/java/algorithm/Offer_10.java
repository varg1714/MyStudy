package algorithm;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author varg
 * @date 2020/11/9 16:12
 */
public class Offer_10 {

    public static int numWays(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int temp1 = 1;
        int temp2 = 2;

        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = (temp1 + temp2) % 1000000007;
            temp1 = temp2;
            temp2 = result;
        }

        return result % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

}
