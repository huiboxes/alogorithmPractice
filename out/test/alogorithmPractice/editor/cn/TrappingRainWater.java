/**
  * 题目Id：42
  * 题目：接雨水
  * 日期：2025-10-26 16:28:53
*/
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5939 👎 0

package leetcode.editor.cn;
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int trap(int[] height) {
            if(height == null || height.length < 2) {
                return 0;
            }

            int max = 0;
            int slow = 0;
            while (slow < height.length) {
                if (height[slow] == 0) {
                    slow++;
                    continue;
                }

                int fast = slow++;
                int maxRightHeight = 0;
                int maxRightIndex = -1;

                // 找第一个大于左边界或最大的右边界
                while (fast < height.length) {
                    if (height[fast] >= height[slow]) {
                        maxRightIndex = fast;
                        break;
                    }

                    if (height[fast] > maxRightHeight) {
                        maxRightHeight = height[fast];
                        maxRightIndex = fast;
                    }
                    fast++;
                }

                if(maxRightinx != -1 && maxRightIndex > slow) {
                    int waterHeight = Math.min(height[slow], height[maxRightHeight]);
                    for (int i = slow + 1; i < maxRightIndex; i++) {
                        max += Math.max(0, Math.min(height[slow], height[maxRightHeight]) - height[i]);
                    }
                    slow = maxRightIndex;
                } else {
                    slow++;
                }

                return max;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 