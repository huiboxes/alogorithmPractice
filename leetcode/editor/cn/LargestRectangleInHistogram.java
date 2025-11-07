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
        // 存柱子索引的单调递增栈
        Stack<Integer> stack = new Stack<>();

        // 原数组前后各添加一个高度为0的哨兵柱子，简化边界处理
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0 ,newHeights, 1, heights.length);

        int maxArea = 0;

        for (int i = 0; i < newHeights.length; i++) {
            // 当前柱子比栈顶柱子矮时说明找到了栈顶柱子的右边界
            // 计算栈顶主子为高的面积
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }


        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 