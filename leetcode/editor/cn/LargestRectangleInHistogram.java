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

package editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {

        return getArea(heights, 0, heights.length - 1);
    }

    private int getArea(int[] heights, int start, int end) {
        // 递归终止条件
        if(start > end) return 0;

        // 找到区间内最小高度柱子的索引
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if(heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }

        // 三种情况取最大值
        // 跨越整个区间
        int areaWithMinHeight = heights[minIndex] * (end - start + 1);

        // 左侧的最大矩形
        int leftMaxArea = getArea(heights, start, minIndex - 1);

        // 右侧的最大矩形
        int rightMaxArea = getArea(heights, minIndex + 1, end);

        return Math.max(areaWithMinHeight, Math.max(leftMaxArea, rightMaxArea));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 