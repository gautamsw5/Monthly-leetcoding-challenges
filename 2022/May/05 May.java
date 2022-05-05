class MyStack {
    Stack<Integer> s = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        s.push(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return s.pop();
    }
    
    /** Get the top element. */
    public int top() {
        return s.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return s.empty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
