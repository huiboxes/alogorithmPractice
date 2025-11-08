/**
  * 题目Id：238
  * 题目：除自身以外数组的乘积
  * 日期：2025-10-29 00:01:38
*/
//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 输入 保证 数组 answer[i] 在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 2133 👎 0

package editor.cn.befor20251108;
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] leftValue = new int[length];
        int[] rightValue = new int[length];
        int[] res = new int[length];

        leftValue[0] = 1;
        for (int i = 1; i < length; i++) {
            leftValue[i] = leftValue[i - 1] * nums[i - 1];
        }

        rightValue[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightValue[i] = rightValue[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            res[i] = leftValue[i] * rightValue[i];
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 