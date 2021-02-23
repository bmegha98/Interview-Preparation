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

//Using Linked List

class ListNode
{
    int val;
    int min;
    ListNode next;
    public ListNode(int v,int m,ListNode ptr)
    {
        val = v;
        min = m;
        next = ptr;
    }
}
class MinStack {

    ListNode head;
    int Min;
    /** initialize your data structure here. */
    public MinStack() {
        head = null;
        Min = Integer.MAX_VALUE;
    }
    
    public void push(int x) 
    {
        if(x < Min)
            Min = x;
        ListNode n = new ListNode(x,Min,head);
        head = n;
    }
    
    public void pop() {
        
        if(head.next != null)
        {
            Min = head.next.min;
            head = head.next;
        }
        else
        {
            head = null;
            Min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return Min;
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
