/**
  * 题目Id：84
  * 题目：柱状图中最大的矩形
  * 日期：2025-11-07 23:34:21
*/
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 3014 👎 0

package editor.cn.befor20251108;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;

        int length = heights.length;
        int[] left = new int[length]; // 柱子向左能扩展到的最远位置
        int[] right = new int[length]; // 柱子向右能扩展到的最远位置

        left[0] = 0;
        for (int i = 1; i < length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p] - 1;
            }
            left[i] = p + 1;
        }

        right[length - 1] = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < length && heights[p] >= heights[i]) {
                p = right[p] + 1;
            }
            right[i] = p - 1;
        }

        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            int width = right[i] -  left[i] + 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 