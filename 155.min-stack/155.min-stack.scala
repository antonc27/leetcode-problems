/*
 * @lc app=leetcode id=155 lang=scala
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (38.57%)
 * Total Accepted:    375.5K
 * Total Submissions: 944.6K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 * 
 * 
 */
class MinStack() {

    /** initialize your data structure here. */
    private var stack: List[(Int, Int)] = List()
    private var currMin: Int = 0
    

    def push(x: Int) {
        if (stack.isEmpty) {
            currMin = x
        } else {
            currMin = math.min(x, currMin)
        }
        stack = (x, currMin) :: stack
    }

    def pop() {
        val (x, min) = stack.head
        stack = stack.tail
        if (!stack.isEmpty) {
            currMin = stack.head._2
        }
        x
    }

    def top(): Int = {
        stack.head._1
    }

    def getMin(): Int = {
        currMin
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
