/**
  * 题目Id：108
  * 题目：将有序数组转换为二叉搜索树
  * 日期：2025-11-13 23:28:52
*/
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1722 👎 0

package editor.cn;


import javax.swing.tree.TreeNode;
import java.util.LinkedList;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> leftQueue = new LinkedList<>();
        LinkedList<Integer> rightQueue = new LinkedList<>();

        TreeNode root = new TreeNode();

        nodeQueue.offer(root);
        leftQueue.offer(0);
        rightQueue.offer(nums.length - 1);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer left = leftQueue.poll();
            Integer right = rightQueue.poll();

            int mid = left + (right - left) / 2;
            node.val = nums[mid];

            if(left <= mid - 1) {
                node.left = new TreeNode();
                nodeQueue.offer(node.left);
                leftQueue.offer(left);
                rightQueue.offer(mid - 1);
            }

            if(mid + 1 <= right) {
                node.right = new TreeNode();
                nodeQueue.offer(node.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }

        }

        return root;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

} 