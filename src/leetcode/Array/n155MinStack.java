package leetcode.Array;

import java.util.Stack;

/**
 * Created by thd on 2017/8/23
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 设计一个支持push，pop，top和在恒定时间内检索最小元素的堆栈。
 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.


 */
public class n155MinStack {
    long min;
    Stack<Long> stack;

    public n155MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min); // could be negative if min value needs to change
            if (x < min)
                min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;//if negative, increase the min value
    }

    public int top() {
        long top = stack.peek();
        if (top > 0)
            return (int) (top + min);
        else
            return (int)(min);
    }

    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
