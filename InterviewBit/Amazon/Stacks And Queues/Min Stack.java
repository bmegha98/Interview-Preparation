/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.
*/

class Solution {
    Stack<Integer> main,aux;
    public Solution() {
        main = new Stack<>();
        aux = new Stack<>();
    }
    public void push(int x) {
        main.push(x);
        if(aux.isEmpty() || aux.peek() >= x)
            aux.push(x);
    }

    public void pop() {
        if(main.isEmpty())
            return;
        int x = main.pop();
        if(x == aux.peek())
            aux.pop();
    }

    public int top() {
        if(main.isEmpty())
            return -1;
        return main.peek();
    }

    public int getMin() {
        if(aux.isEmpty())
            return -1;
        return aux.peek();
    }
}
