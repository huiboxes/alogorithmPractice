/**
  * 题目Id：155
  * 题目：最小栈
  * 日期：2025-11-05 23:57:23
*/
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 2003 👎 0

package editor.cn;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicStampedReference;

public class MinStack {
    public static void main(String[] args) {
        Solution solution = new MinStack().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

        private Stack<Long> stack;
        private long min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if(val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        Long diff = stack.pop();
        if(diff < 0 ) {
            min = min - diff;
        }
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        Long diff = stack.peek();
        if(diff < 0) {
            return (int)min;
        } else {
            return (int) (min + diff);
        }
    }
    
    public int getMin() {
        return (int) min;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

} 