package algorithm;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author varg
 * @date 2020/11/9 15:13
 */
public class Offer_03 {

    /*public int findRepeatNumber(int[] nums) {
        int result = 0;
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!sets.contains(nums[i])) {
                sets.add(nums[i]);
            } else {
                result = nums[i];
                break;
            }
        }
        return result;
    }*/

    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // nums[i] = 5; i = 1
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                // temp = 5; i = 1
                int temp = nums[i];
                nums[i] = i;

            }
        }

        String s = "";

        return -1;
    }

}
