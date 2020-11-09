package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author varg
 * @date 2020/11/9 15:13
 */
public class Offer_06 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode node = new ListNode(head.val);

        ListNode result = head;
        int size = 1;

        while (head.next != null) {
            ListNode temp = new ListNode(head.next.val);
            temp.next = node;
            node = temp;
            result = temp;
            head = head.next;
            size++;
        }
        int[] numbers = new int[size];
        int i = 0;
        numbers[0] = result.val;
        while (result.next != null) {
            i++;
            numbers[i] = result.next.val;
            result = result.next;
        }

        return numbers;
    }

}
