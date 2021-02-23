/*
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and 
empty).
Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
*/

class MyQueue {
    
    Stack<Integer> s1,s2;

    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        
        s1 = new Stack<>();
        s2 = new Stack<>();
        front = -1;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        if(s1.isEmpty())
            front = x;
        s1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        return s2.isEmpty()?front:s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return s1.isEmpty()&&s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
