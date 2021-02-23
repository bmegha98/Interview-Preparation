/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {

    Stack<Integer> main,aux;
    /** initialize your data structure here. */
    public MinStack() {
        main = new Stack<>();
        aux = new Stack<>();
    }
    
    public void push(int x) {
        main.push(x);
        if(aux.isEmpty() || aux.peek() >= x)
            aux.push(x);
    }
    
    public void pop() {
        
        int tmp = main.pop();
        if(tmp == aux.peek())
            aux.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return aux.peek();
    }
}
