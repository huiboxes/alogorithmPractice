/**
  * 题目Id：234
  * 题目：回文链表
  * 日期：2025-10-30 21:39:29
*/
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 2147 👎 0

package editor.cn.befor20251108;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {

//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondList = reverseList(slow.next);

        ListNode firstHalf = head;
        while (secondList != null) {
            if(firstHalf.val != secondList.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondList = secondList.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }

        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 