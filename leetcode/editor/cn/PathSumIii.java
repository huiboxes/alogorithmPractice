/**
  * 题目Id：437
  * 题目：路径总和 III
  * 日期：2025-11-17 23:11:17
*/
//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2173 👎 0

package editor.cn;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);

        return dfs(root, targetSum, prefixSumMap, 0);
    }

    private int dfs(TreeNode node, int targetSum, Map<Long, Integer> prefixSumMap, long currentSum) {
        if(node == null) return 0;

        // 更新当前路径的前缀和
        currentSum += node.val;

        int count = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, targetSum, prefixSumMap, currentSum);
        count += dfs(node.right, targetSum, prefixSumMap, currentSum);

        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 