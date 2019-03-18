package offer;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (minStack.empty()) {
            minStack.push(number);
        } else if (minStack.peek() >= number) {
            minStack.push(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}
