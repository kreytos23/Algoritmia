package ADA;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> auxStack = new Stack<>();
        this.stack.push(x);
        while (!this.stack.isEmpty()) {
            auxStack.push(this.stack.pop());
        }
        this.stack = auxStack;
    }

    public int pop(int x) {
        Stack<Integer> auxStack = new Stack<>();
        this.stack.push(x);
        while (!this.stack.isEmpty()) {
            auxStack.push(this.stack.pop());
        }
        auxStack.pop();
        this.stack = auxStack;
        while (!this.stack.isEmpty()) {
            auxStack.push(this.stack.pop());
        }
        this.stack = auxStack;
        return this.stack.peek();
    }

    public int peek() {
        return stack.lastElement();
    }

    public boolean empty() {
        return stack.empty();
    }
}
